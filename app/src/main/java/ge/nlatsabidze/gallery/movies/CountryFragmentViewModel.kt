package ge.nlatsabidze.gallery.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ge.nlatsabidze.gallery.model.CityData

import ge.nlatsabidze.gallery.network.ApiInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class CountryFragmentViewModel : ViewModel() {

    private var _mainCityInformation = MutableLiveData<CityData>()
    val mainCityInformation: LiveData<CityData>
        get() = _mainCityInformation

    fun setResult() {
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO) {
                ApiInstance.API.getItems()
            }

            try {
                if (data.isSuccessful && data.body() != null) {
                    _mainCityInformation.postValue(data.body())
                }
            } catch (e: Exception) {
                Log.d("error", e.toString())
            }
        }
    }
}