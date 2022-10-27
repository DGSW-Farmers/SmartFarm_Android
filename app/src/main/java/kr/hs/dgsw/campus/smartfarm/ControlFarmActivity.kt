package kr.hs.dgsw.campus.smartfarm

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import kr.hs.dgsw.campus.smartfarm.databinding.ActivityControlFarmBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ControlFarmActivity : AppCompatActivity(), View.OnClickListener {
    private var currentposition: Int = 0
    private var fragment: Fragment? = null
    private var data: SensorData? = null
    private var floor = 1
    private val timer = Timer()
    private lateinit var binding: ActivityControlFarmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_control_farm)

        val TT: TimerTask = object : TimerTask() {
            override fun run() {
                getData(floor)
            }
        }
        timer.schedule(TT, 0, 5000) //Timer 실행

        initListener()

        binding.controlVp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentposition = position
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    override fun onStop() {
        super.onStop()
        timer.cancel()
    }

    private fun getData(floor: Int) {
        RetrofitBuilder.api.getData(floor).enqueue(object :
            Callback<SensorData> {
            override fun onResponse(
                call: Call<SensorData>,
                response: Response<SensorData>,
            ) {
                if (response.isSuccessful) {
                    data = response.body()
                    initVpAndIndicator()
                }
            }
            override fun onFailure(call: Call<SensorData>, t: Throwable) {
                Log.d("testasd", "실패$t")
            }
        })
    }

    private fun initVpAndIndicator() {
        binding.controlVp.adapter = ViewPagerAdapter(this)
        binding.controlVpIndicator.attachTo(binding.controlVp)
        binding.controlVp.currentItem = currentposition
    }


    private fun initListener() {
        binding.changeBtn.setOnClickListener(this)
        binding.firstFloorLayout.setOnClickListener(this)
        binding.secondFloorLayout.setOnClickListener(this)
        binding.thirdFloorLayout.setOnClickListener(this)
        binding.historyBtn.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        when (p0) {
            binding.changeBtn -> {
                val intent = Intent(this, MainActivity::class.java)
                finish()
                startActivity(intent)
            }
            binding.firstFloorLayout -> {
                floor = 1
                getData(floor)
                changeLayout(binding.firstFloorText)
            }
            binding.secondFloorLayout -> {
                floor = 2
                getData(floor)
                changeLayout(binding.secondFloorText)
            }
            binding.thirdFloorLayout -> {
                floor = 3
                getData(floor)
                changeLayout(binding.thirdFloorText)
            }
            binding.historyBtn -> {
                val intent = Intent(this, HistoryActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun changeLayout(view: View) {
        val list = listOf(binding.firstFloorText, binding.secondFloorText, binding.thirdFloorText)

        val layoutParams: ConstraintLayout.LayoutParams =
            view.layoutParams as ConstraintLayout.LayoutParams
        val RightMarginDp: Int =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 70F, resources.displayMetrics)
                .toInt()
        layoutParams.rightMargin = RightMarginDp
        view.layoutParams = layoutParams

        for (i in 0..2) {
            if (list[i] != view) {
                val mlayoutParams: ConstraintLayout.LayoutParams =
                    list[i].layoutParams as ConstraintLayout.LayoutParams
                val mRightMarginDp: Int =
                    TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        50F,
                        resources.displayMetrics
                    ).toInt()
                mlayoutParams.rightMargin = mRightMarginDp
                list[i].layoutParams = mlayoutParams
            }
        }
    }

    private inner class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            when (position) {
                0 -> {
                    val bundle = Bundle(3)
                    bundle.putInt("humidity", data!!.humidity.toInt())
                    bundle.putFloat("temperature", (data!!.temperature).toFloat())
                    bundle.putInt("waterLevel", data!!.waterLevel.toInt())
                    fragment = StateFarmFirstFragment()
                    fragment!!.arguments = bundle


                }
                1 -> {
                    val bundle = Bundle(2)
                    bundle.putFloat("liquid", data!!.liquid.toFloat())
                    bundle.putFloat("sunlight ", data!!.sunlight.toFloat())
                    fragment = StateFarmSecondFragment()
                    fragment!!.arguments = bundle

                }
                else -> {
                    fragment = ControlFarmFragment()
                }
            }
            return fragment!!
        }
    }
}