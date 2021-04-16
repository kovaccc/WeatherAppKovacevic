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


@HiltViewModel
class MainViewModel @Inject constructor(private val weatherRepository: WeatherRepository): ViewModel() {

    private val _currentWeatherMLD = MutableLiveData<Resource<WeatherResponse>>()
    val currentWeatherLD: LiveData<Resource<WeatherResponse>>
        get() = _currentWeatherMLD

        fun searchCityWeather(city: String) {

            viewModelScope.launch {
                _currentWeatherMLD.value = Resource.loading(null)
                _currentWeatherMLD.value = weatherRepository.getWeather(city)
            }

        }

}

