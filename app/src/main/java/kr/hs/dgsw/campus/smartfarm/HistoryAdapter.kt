package kr.hs.dgsw.campus.smartfarm

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.campus.smartfarm.databinding.HistoryListItemBinding
import java.time.LocalDateTime
import java.util.*
import kotlin.coroutines.coroutineContext

class HistoryAdapter(val context: HistoryActivity) : RecyclerView.Adapter<HistoryAdapter.HistoryVH>() {
    var data = mutableListOf<HistoryData>()
    var id = 0
    private var minstart: Long = 0
    private var maxend: Long = 0
    private var selectstart: Long = 0
    private var selectend: Long = 0
    private var calendar: Calendar = Calendar.getInstance()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryVH {
        val binding = HistoryListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HistoryVH(binding)
    }

    override fun onBindViewHolder(holder: HistoryVH, position: Int) {
        val history = data[position]
        holder.setData(history)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class HistoryVH(val binding: HistoryListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(history: HistoryData) {
            id = history.vegetableData.deviceId
            calendar = Calendar.getInstance().apply { set(history.vegetableData.startDate.substring(0,4).toInt(), (history.vegetableData.startDate.substring(5,7).toInt())-1, history.vegetableData.startDate.substring(8).toInt()) }
            minstart = calendar.timeInMillis
            var currentDate =
                Calendar.getInstance().apply { set(history.vegetableData.endDate.substring(0,4).toInt(), (history.vegetableData.endDate.substring(5,7).toInt())-1, history.vegetableData.endDate.substring(8).toInt()) }
            maxend = currentDate.timeInMillis
            selectstart = minstart
            selectend = maxend
            Log.d("testasd", maxend.toString())
            Log.d("testasd", minstart.toString())

            binding.itemTitle.text = history.vegetableData.name
            binding.itemStart.text = "시작일 : ${history.vegetableData.startDate}"
            binding.itemEnd.text = "종료일 : ${history.vegetableData.endDate}"
            binding.startText.text = history.vegetableData.startDate.substring(0,4)+"."+history.vegetableData.startDate.substring(5,7)+"."+history.vegetableData.startDate.substring(8)
            binding.endText.text = history.vegetableData.endDate.substring(0,4)+"."+history.vegetableData.endDate.substring(5,7)+"."+history.vegetableData.endDate.substring(8)
            binding.progressHumidity.progress = history.historySensorData.avgData.humidity.toFloat().toInt()
            binding.progressTemperature.progress = history.historySensorData.avgData.temperature.toFloat().toInt()
            binding.progressLevel.progress = history.historySensorData.avgData.waterLevel.toFloat().toInt()
            binding.tvHumidityValue.text = history.historySensorData.avgData.humidity.toFloat().toInt().toString() + "%"
            binding.tvTemperatureValue.text = history.historySensorData.avgData.temperature.toFloat().toInt().toString() + "°C"
            binding.tvLevelValue.text = history.historySensorData.avgData.waterLevel.toFloat().toInt().toString() + "L"
            binding.arrowBtn.setOnClickListener {
                if(binding.itemStateLayout.visibility == View.GONE){
                    binding.itemStateLayout.visibility = View.VISIBLE
                    binding.arrowBtn.rotation = 270f
                } else {
                    binding.itemStateLayout.visibility = View.GONE
                    binding.arrowBtn.rotation = 180f
                }
            }
            binding.startText.setOnClickListener {
                calendar(binding.startText)
            }
            binding.endText.setOnClickListener {
                calendar(binding.endText)
            }
        }


        private fun calendar(view: TextView) {
            if (view == binding.startText) {
                if (maxend.toInt() != 0) {
                    DatePickerDialog(
                        context,
                        { _, year, monthOfYear, dayOfMonth ->
                            // 선택된 날짜가 필요하면 이 currentDate 변수를 적절하게 사용하면 된다.
                            val currentDate =
                                Calendar.getInstance().apply { set(year, monthOfYear, dayOfMonth) }
                            selectstart = currentDate.timeInMillis
                            view.text = "$year.${monthOfYear+1}.$dayOfMonth"
                            getData()

                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                    ).apply {
                        datePicker.minDate = minstart
                        datePicker.maxDate = maxend
                        if(selectend.toInt() != 0){
                            datePicker.maxDate = selectend
                        }
                    }.show()
                }

            } else if (view == binding.endText) {
                if (minstart.toInt() != 0) {
                    DatePickerDialog(
                        context,
                        { _, year, monthOfYear, dayOfMonth ->
                            // 선택된 날짜가 필요하면 이 currentDate 변수를 적절하게 사용하면 된다.
                            val currentDate =
                                Calendar.getInstance().apply { set(year, monthOfYear, dayOfMonth) }
                            selectend = currentDate.timeInMillis
                            view.text = "$year.${monthOfYear+1}.$dayOfMonth"
                            getData()
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                    ).apply {
                        datePicker.minDate = minstart
                        datePicker.maxDate = maxend
                        if(selectstart.toInt() != 0){
                            datePicker.minDate = selectstart
                        }
                    }.show()
                }
            }

        }

        private fun getData(){
            val tempCalendar: Calendar = Calendar.getInstance()
            tempCalendar.timeInMillis = selectstart
            val start = tempCalendar.get(Calendar.YEAR).toString() + "-" + (tempCalendar.get(Calendar.MONTH)+1).toString() + "-" + tempCalendar.get(Calendar.DAY_OF_MONTH).toString()
            tempCalendar.timeInMillis = selectend
            val end = tempCalendar.get(Calendar.YEAR).toString() + "-" + (tempCalendar.get(Calendar.MONTH)+1).toString() + "-" + tempCalendar.get(Calendar.DAY_OF_MONTH).toString()
            val data = context.sensorList[id-4]

            binding.progressHumidity.progress = data.avgData.humidity.toInt()
            binding.progressTemperature.progress = data.avgData.temperature.toInt()
            binding.progressLevel.progress = data.avgData.waterLevel.toInt()
            binding.tvHumidityValue.text = data.avgData.humidity + "%"
            binding.tvTemperatureValue.text = data.avgData.temperature + "°C"
            binding.tvLevelValue.text = data.avgData.waterLevel + "L"
        }



    }




}
