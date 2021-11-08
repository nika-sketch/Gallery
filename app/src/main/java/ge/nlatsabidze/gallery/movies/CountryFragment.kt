package ge.nlatsabidze.gallery.movies

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ge.nlatsabidze.gallery.BaseFragment
import ge.nlatsabidze.gallery.R
import ge.nlatsabidze.gallery.databinding.CountryFragmentBinding

class CountryFragment : BaseFragment<CountryFragmentBinding>(CountryFragmentBinding::inflate) {

    private val cityViewModel: CountryFragmentViewModel by viewModels()

    override fun start() {
        setResultFun()
    }

    private fun setResultFun() {
        cityViewModel.setResult()

        cityViewModel.mainCityInformation.observe(viewLifecycleOwner, {
            binding.cityName.text = it.location?.name
            binding.countryNameId.text = it.location?.country

            Glide.with(requireContext())
                .load("https:" + it.current?.condition?.icon)
                .into(binding.ivCondition)

            binding.tvCelcius.text = it.current?.tempC.toString()
            binding.tvFarengheit.text = it.current?.tempF.toString()

            binding.tvCondition.text = it.current?.condition?.text.toString()
            binding.tvHumidity.text = it.current?.humidity.toString()

        })

        binding.btnReturnToMenu.setOnClickListener {
            findNavController().navigate(R.id.action_countryFragment_to_menuFragment)
        }
    }
}