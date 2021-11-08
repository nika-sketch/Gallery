package ge.nlatsabidze.gallery.dailyFragment

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ge.nlatsabidze.gallery.BaseFragment
import ge.nlatsabidze.gallery.adapters.DailyInfoAdapter
import ge.nlatsabidze.gallery.databinding.FragmentDailyInfoBinding


class DailyInfoFragment : BaseFragment<FragmentDailyInfoBinding>(FragmentDailyInfoBinding::inflate) {

    private val dailyViewModel: DailyInfoViewModel by viewModels()
    private lateinit var itemAdapter: DailyInfoAdapter

    override fun start() {
        setUpDailyRecyclerView()
        setResult()
    }

    private fun setUpDailyRecyclerView() {
        binding.rvDaily.apply {
            itemAdapter = DailyInfoAdapter()
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun setResult() {
        dailyViewModel.setResult()

        dailyViewModel.dailyTemp.observe(viewLifecycleOwner, {
            itemAdapter.temperature = it
        })
    }

}