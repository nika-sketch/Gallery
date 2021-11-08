package ge.nlatsabidze.gallery.dailyFragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ge.nlatsabidze.gallery.daily.Daily
import ge.nlatsabidze.gallery.daily.Day
import ge.nlatsabidze.gallery.daily.Temp
import ge.nlatsabidze.gallery.modelPolution.AirPolution
import ge.nlatsabidze.gallery.network.ApiInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class DailyInfoViewModel: ViewModel() {

    private var _dailyTemp = MutableLiveData<List<Daily>>()
    val dailyTemp: LiveData<List<Daily>>
        get() = _dailyTemp

    fun setResult() {
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO) {
                ApiInstance.SECONDAPI.getDaily()
            }

            try {
                if (data.isSuccessful && data.body() != null) {
                    _dailyTemp.postValue(data.body()?.daily!!)
                }
            } catch (e: Exception) {
                Log.d("error", e.toString())
            }
        }
    }
}