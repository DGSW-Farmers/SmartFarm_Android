package kr.hs.dgsw.campus.smartfarm

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import kr.hs.dgsw.campus.smartfarm.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity(), View.OnClickListener {
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
        val historyAdapter = HistoryAdapter()
        binding.rcvHistory.adapter = historyAdapter
        binding.rcvHistory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        historyAdapter.data = mutableListOf(
            HistoryData("상추", "2019.02.21", "2022.02.22", "50", "25", "10"),
            HistoryData("상추", "2019.02.21", "2022.02.22", "50", "25", "10"),
            HistoryData("상추", "2019.02.21", "2022.02.22", "50", "25", "10"),
        )
        historyAdapter.notifyDataSetChanged()
    }

    override fun onClick(p0: View?) {
        when(p0) {
            binding.backBtn -> {
                finish()
            }
        }
    }
}