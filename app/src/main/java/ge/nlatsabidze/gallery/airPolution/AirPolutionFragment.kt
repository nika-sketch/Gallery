package ge.nlatsabidze.gallery.airPolution

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ge.nlatsabidze.gallery.BaseFragment
import ge.nlatsabidze.gallery.adapters.AirPolutionAdapter
import ge.nlatsabidze.gallery.databinding.FragmentAirPolutionBinding

class AirPolutionFragment : BaseFragment<FragmentAirPolutionBinding>(FragmentAirPolutionBinding::inflate) {

    private lateinit var itemAdapter: AirPolutionAdapter

    private val airPolutionViewModel: AirPolutionViewModel by viewModels()


    override fun start() {
        setUpAirPolutionList()
        setResult()
    }

    private fun setUpAirPolutionList() {
        binding.rvAirPolution.apply {
            itemAdapter = AirPolutionAdapter()
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun setResult() {
        airPolutionViewModel.setResult()

        airPolutionViewModel.infoAirPolution.observe(viewLifecycleOwner, {
            itemAdapter.airPolutionData = it.list!!
        })
    }
}