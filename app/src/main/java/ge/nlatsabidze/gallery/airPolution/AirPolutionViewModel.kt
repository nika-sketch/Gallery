package ge.nlatsabidze.gallery.airPolution

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ge.nlatsabidze.gallery.modelPolution.AirPolution
import ge.nlatsabidze.gallery.network.ApiInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AirPolutionViewModel: ViewModel() {

    private var _infoAirPolution = MutableLiveData<AirPolution>()
    val infoAirPolution: LiveData<AirPolution>
        get() = _infoAirPolution

    fun setResult() {
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO) {
                ApiInstance.SECONDAPI.getAirPolutionItems()
            }

            try {
                if (data.isSuccessful && data.body() != null) {
                    _infoAirPolution.postValue(data.body())
                }

            } catch (e: Exception) {
                Log.d("error", e.toString())
            }
        }
    }
}