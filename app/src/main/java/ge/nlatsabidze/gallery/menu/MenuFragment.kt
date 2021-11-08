package ge.nlatsabidze.gallery.menu

import androidx.navigation.fragment.findNavController
import ge.nlatsabidze.gallery.BaseFragment
import ge.nlatsabidze.gallery.R
import ge.nlatsabidze.gallery.databinding.FragmentMenuBinding

class MenuFragment : BaseFragment<FragmentMenuBinding>(FragmentMenuBinding::inflate) {

    override fun start() {
        binding.currentWeather.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_countryFragment)
        }
        binding.btnAirPolution.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_airPolutionFragment)
        }
        binding.btnDaily.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_dailyInfoFragment)
        }
    }
}