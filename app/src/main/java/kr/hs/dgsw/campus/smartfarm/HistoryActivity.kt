package kr.hs.dgsw.campus.smartfarm

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import kr.hs.dgsw.campus.smartfarm.databinding.ActivityHistoryBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var historyAdapter: HistoryAdapter
    private var index = 4
    private var historyData = mutableListOf<HistoryData>()
    private var vegetableList: MutableList<VegetableData> = mutableListOf()
    var sensorList: MutableList<HistorySensorData> = mutableListOf()
    private lateinit var binding: ActivityHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_history)

        initListener()
        setRcv()
    }

    private fun initListener() {
        binding.backBtn.setOnClickListener(this)
    }



    private fun setRcv() {

        historyAdapter = HistoryAdapter(this)
        binding.rcvHistory.adapter = historyAdapter
        binding.rcvHistory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        getVegetableData()
    }

    override fun onClick(p0: View?) {
        when(p0) {
            binding.backBtn -> {
                finish()
            }
        }
    }

    private fun getVegetableData() {
        RetrofitBuilder.api.getVegetableData(index).enqueue(object :
            Callback<VegetableData> {
            override fun onResponse(
                call: Call<VegetableData>,
                response: Response<VegetableData>,
            ) {
                Log.d("testasd", response.body().toString())
                if (response.isSuccessful) {
                    vegetableList.add(response.body()!!)

                    Log.d("testasd", index.toString())
                    Log.d("testasd", vegetableList[index-4].toString())
                    getSensorData(index, vegetableList[index-4].startDate, vegetableList[index-4].endDate)
                }
            }
            override fun onFailure(call: Call<VegetableData>, t: Throwable) {
                Log.d("testasd", "실패$t")
            }
        })
    }

    private fun getSensorData(deviceId: Int, start: String, end: String) {
//        val periodData = PeriodData(deviceId, end, start)
//        Log.d("testasd", periodData.toString())
        Log.d("testasd", deviceId.toString())
        Log.d("testasd", start)
        Log.d("testasd", end)
        RetrofitBuilder.api.getSensorData(deviceId, end, start).enqueue(object :
            Callback<HistorySensorData> {
            override fun onResponse(
                call: Call<HistorySensorData>,
                response: Response<HistorySensorData>,
            ) {
//                Log.d("testasdasd", response.body().toString())
                if (response.isSuccessful) {
                    sensorList.add(response.body()!!)
                    historyData.add(HistoryData(vegetableList[index-4], sensorList[index-4]))
                    Log.d("testasd", historyData.toString())
                    if(index == 8){
                        historyAdapter.data = historyData
                        historyAdapter.notifyDataSetChanged()
                    } else {
                        index++
                        getVegetableData()
                    }
                }
            }
            override fun onFailure(call: Call<HistorySensorData>, t: Throwable) {
                Log.d("testasd", "실패$t")
            }
        })
    }
}