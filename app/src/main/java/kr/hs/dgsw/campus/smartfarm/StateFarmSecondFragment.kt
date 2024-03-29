package kr.hs.dgsw.campus.smartfarm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.hs.dgsw.campus.smartfarm.databinding.FragmentStateFarmSecondBinding

class StateFarmSecondFragment : Fragment() {
    lateinit var binding: FragmentStateFarmSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentStateFarmSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle: Bundle = requireArguments()
        val liquid: Int = bundle.getFloat("liquid").toInt()
        val sunlight : Int = bundle.getFloat("sunlight ").toInt()

        binding.progressPh.progress = liquid
        binding.tvPhValue.text = "${liquid}ph"

        binding.progressSunshine.progress = sunlight
        binding.tvSunshineValue.text = "${sunlight}"


    }

}