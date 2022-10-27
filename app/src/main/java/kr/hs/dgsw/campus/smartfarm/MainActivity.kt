package kr.hs.dgsw.campus.smartfarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import kr.hs.dgsw.campus.smartfarm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

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

            }
            binding.tomatoLayout -> {

            }
            binding.napaCabbageLayout -> {

            }
            binding.confirmBtn -> {

            }
            binding.changeBtn -> {
                val intent = Intent(this, ControlFarmActivity::class.java)
                finish()
                startActivity(intent)
            }
        }
    }

}