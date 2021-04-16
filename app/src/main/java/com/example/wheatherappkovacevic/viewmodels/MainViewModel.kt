package com.example.wheatherappkovacevic.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wheatherappkovacevic.data.models.WeatherResponse
import com.example.wheatherappkovacevic.repositories.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.wheatherappkovacevic.utils.Resource
import com.example.wheatherappkovacevic.utils.Status

@HiltViewModel
class MainViewModel @Inject constructor(private val weatherRepository: WeatherRepository): ViewModel() {

    private val _currentWeatherMLD = MutableLiveData<WeatherResponse>()
    val currentWeatherLD: LiveData<WeatherResponse>
        get() = _currentWeatherMLD

    private val _currentSnackbarMLD = MutableLiveData<String?>()
    val currentSnackbarLD: LiveData<String?>
        get() = _currentSnackbarMLD

    private val _currentProgressMLD = MutableLiveData<Boolean>()
    val currentProgressbarLD: LiveData<Boolean>
        get() = _currentProgressMLD


        fun searchCityWeather(city: String) {

            viewModelScope.launch {

                val result = weatherRepository.getWeather(city)
                 when(result.status) {
                     Status.SUCCESS -> {
                         _currentWeatherMLD.value = result.data!!
                         resetSnackBarState()
                         resetProgressState()
                     }
                     Status.ERROR-> {
                         _currentSnackbarMLD.value = result.message!!
                         resetProgressState()
                     }
                     Status.LOADING -> {
                         _currentProgressMLD.value = true

                     }
                 }
            }
        }

    fun resetSnackBarState() {
        _currentSnackbarMLD.value = null
    }


    private fun resetProgressState() {
        _currentProgressMLD.value = false
    }


}

