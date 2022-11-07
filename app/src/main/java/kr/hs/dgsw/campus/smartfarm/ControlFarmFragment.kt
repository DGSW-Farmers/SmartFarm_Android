package kr.hs.dgsw.campus.smartfarm

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.hs.dgsw.campus.smartfarm.databinding.FragmentControlFarmBinding
import kotlin.math.floor

class ControlFarmFragment(val led: Boolean, val pump: Boolean, val ventilator: Boolean) : Fragment(), View.OnClickListener {
    lateinit var binding: FragmentControlFarmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentControlFarmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        binding.switchLed.isChecked = led
        binding.switchPump.isChecked = pump
        binding.switchVentilator.isChecked = ventilator
    }

    private fun initListener() {
        binding.switchLed.setOnClickListener(this)
        binding.switchPump.setOnClickListener(this)
        binding.switchVentilator.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            binding.switchLed -> {
                if(binding.switchLed.isChecked){
                    (activity as ControlFarmActivity).sendMessage("d")
                    (activity as ControlFarmActivity).sendMessage("f")
                } else {
                    (activity as ControlFarmActivity).sendMessage("e")
                    (activity as ControlFarmActivity).sendMessage("g")
                }
                (activity as ControlFarmActivity).led = binding.switchLed.isChecked
            }
            binding.switchPump -> {
                when((activity as ControlFarmActivity).floor){
                    1 -> {
                        if(binding.switchPump.isChecked){
                            (activity as ControlFarmActivity).sendMessage("1")
                            (activity as ControlFarmActivity).sendMessage("3")
                        } else {
                            (activity as ControlFarmActivity).sendMessage("2")
                            (activity as ControlFarmActivity).sendMessage("4")
                        }
                    }
                    2 -> {
                        if(binding.switchPump.isChecked){
                            (activity as ControlFarmActivity).sendMessage("5")
                            (activity as ControlFarmActivity).sendMessage("7")
                        } else {
                            (activity as ControlFarmActivity).sendMessage("6")
                            (activity as ControlFarmActivity).sendMessage("8")
                        }
                    }
                    3 -> {
                        if(binding.switchPump.isChecked){
                            (activity as ControlFarmActivity).sendMessage("9")
                            (activity as ControlFarmActivity).sendMessage("b")
                        } else {
                            (activity as ControlFarmActivity).sendMessage("a")
                            (activity as ControlFarmActivity).sendMessage("c")
                        }
                    }
                }
                (activity as ControlFarmActivity).pump[(activity as ControlFarmActivity).floor-1] = binding.switchPump.isChecked
            }
            binding.switchVentilator -> {
                if(binding.switchVentilator.isChecked){
                    (activity as ControlFarmActivity).sendMessage("h")
                    (activity as ControlFarmActivity).sendMessage("j")
                } else {
                    (activity as ControlFarmActivity).sendMessage("i")
                    (activity as ControlFarmActivity).sendMessage("k")
                }
                (activity as ControlFarmActivity).ventilator = binding.switchVentilator.isChecked
            }
        }
    }



}