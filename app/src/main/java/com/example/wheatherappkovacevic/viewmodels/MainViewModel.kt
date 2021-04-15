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

@HiltViewModel
class MainViewModel @Inject constructor(private val weatherRepository: WeatherRepository): ViewModel() {

    private val _currentWeatherMLD = MutableLiveData<WeatherResponse>()
    val currentWeatherLD: LiveData<WeatherResponse>
        get() = _currentWeatherMLD


        fun searchCityWeather(city: String) {

            viewModelScope.launch {
                weatherRepository.getWeather(city)
            }

        }


}

