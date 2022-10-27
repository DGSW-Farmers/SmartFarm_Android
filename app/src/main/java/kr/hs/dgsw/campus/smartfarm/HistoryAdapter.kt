package kr.hs.dgsw.campus.smartfarm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.campus.smartfarm.databinding.HistoryListItemBinding

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryVH>() {

    var data = mutableListOf<HistoryData>()

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
            binding.itemTitle.text = history.name
            binding.itemStart.text = "시작일 : ${history.start}"
            binding.itemEnd.text = "종료일 : ${history.end}"
            binding.progressHumidity.progress = history.humidity.toInt()
            binding.progressTemperature.progress = history.temperature.toInt()
            binding.progressLevel.progress = history.waterLevel.toInt()
            binding.arrowBtn.setOnClickListener {
                if(binding.itemStateLayout.visibility == View.GONE){
                    binding.itemStateLayout.visibility = View.VISIBLE
                    binding.arrowBtn.rotation = 270f
                } else {
                    binding.itemStateLayout.visibility = View.GONE
                    binding.arrowBtn.rotation = 180f
                }
            }
        }
    }
}
