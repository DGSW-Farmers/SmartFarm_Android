package kr.hs.dgsw.campus.smartfarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import kr.hs.dgsw.campus.smartfarm.databinding.ActivityControlFarmBinding

class ControlFarmActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityControlFarmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_control_farm)



        initListener()
        initVpAndIndicator()

    }

    private fun initVpAndIndicator() {
        binding.controlVp.adapter = ViewPagerAdapter(this)
        binding.controlVpIndicator.attachTo(binding.controlVp)
    }


    private fun initListener() {
        binding.topLayout.setOnClickListener(this)
        binding.changeBtn.setOnClickListener(this)
    }

    private fun changeState() {
        val state = binding.controlFrame.panelState
        // 닫힌 상태일 경우 열기
        if (state == SlidingUpPanelLayout.PanelState.COLLAPSED) {
            binding.controlFrame.panelState = SlidingUpPanelLayout.PanelState.ANCHORED
        }
        // 열린 상태일 경우 닫기
        else if (state == SlidingUpPanelLayout.PanelState.EXPANDED) {
            binding.controlFrame.panelState = SlidingUpPanelLayout.PanelState.COLLAPSED
        }
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.topLayout -> {
                changeState()
            }
            binding.changeBtn -> {
                val intent = Intent(this, MainActivity::class.java)
                finish()
                startActivity(intent)
            }
        }
    }

    private inner class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {

            return when (position) {
                0 -> {
                    StateFarmFirstFragment()
                }
                1 -> {
                    StateFarmSecondFragment()
                }
                else -> {
                    ControlFarmFragment()
                }
            }
        }
    }
}