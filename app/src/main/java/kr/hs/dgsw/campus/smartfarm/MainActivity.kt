package kr.hs.dgsw.campus.smartfarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import kr.hs.dgsw.campus.smartfarm.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var name: String = ""
    private var floor: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        floor = intent.getIntExtra("floor", 1)

        initListener()

    }

    private fun initListener() {
        binding.lettuceLayout.setOnClickListener(this)
        binding.tomatoLayout.setOnClickListener(this)
        binding.napaCabbageLayout.setOnClickListener(this)
        binding.confirmBtn.setOnClickListener(this)
        binding.changeBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.lettuceLayout -> {
                name="상추"
            }
            binding.tomatoLayout -> {
                name="토마토"
            }
            binding.napaCabbageLayout -> {
                name="배추"
            }
            binding.confirmBtn -> {
                if(name.isBlank()){
                    Toast.makeText(this, "작물을 선택해주세요", Toast.LENGTH_SHORT).show()
                } else {

                }
            }
            binding.changeBtn -> {
                val intent = Intent(this, ControlFarmActivity::class.java)
                finish()
                startActivity(intent)
            }
        }
    }

//    private fun postData(floor: Int) {
//        RetrofitBuilder.api.getData(floor).enqueue(object :
//            Callback<SensorData> {
//            override fun onResponse(
//                call: Call<SensorData>,
//                response: Response<SensorData>,
//            ) {
//                if (response.isSuccessful) {
//                    data = response.body()
//                    initVpAndIndicator()
//                }
//            }
//            override fun onFailure(call: Call<SensorData>, t: Throwable) {
//                Log.d("testasd", "실패$t")
//            }
//        })
//    }

}