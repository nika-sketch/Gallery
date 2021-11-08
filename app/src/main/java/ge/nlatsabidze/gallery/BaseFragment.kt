package ge.nlatsabidze.gallery

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.text.SimpleDateFormat
import java.util.*

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(private val inflate: Inflate<VB>) : Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)

        changeBackgroundAccordingToTime()
        start()

        return binding.root
    }

    @SuppressLint("ResourceAsColor")
    private fun changeBackgroundAccordingToTime() {
        val currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())

        var localTime = ""
        localTime += currentTime[0]
        localTime += currentTime[1]

        var localTimeToInt = localTime.toInt()
        if (localTimeToInt in 7..17) {
            binding.root.setBackgroundColor(Color.WHITE)
        } else {
            binding.root.setBackgroundColor(Color.WHITE)
        }
    }

    abstract fun start()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}