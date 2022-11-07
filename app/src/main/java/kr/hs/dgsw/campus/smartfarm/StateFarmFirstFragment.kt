package kr.hs.dgsw.campus.smartfarm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kr.hs.dgsw.campus.smartfarm.databinding.FragmentStateFarmFirstBinding


class StateFarmFirstFragment : Fragment() {
    lateinit var binding: FragmentStateFarmFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentStateFarmFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle: Bundle = requireArguments()
        val humidity: Int = bundle.getInt("humidity")
        val temperature: Int = bundle.getInt("temperature")
        val waterLevel: Int = bundle.getInt("waterLevel")

        binding.progressHumidity.progress = humidity
        binding.tvHumidityValue.text = "${humidity}%"

        binding.progressTemperature.progress = temperature
        binding.tvTemperatureValue.text = "${temperature}°C"

        binding.progressLevel.progress = waterLevel
        binding.tvLevelValue.text = "${waterLevel}L"
    }

}