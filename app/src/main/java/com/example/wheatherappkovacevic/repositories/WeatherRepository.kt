package com.example.wheatherappkovacevic.repositories

import com.example.wheatherappkovacevic.data.models.WeatherResponse
import com.example.wheatherappkovacevic.utils.Resource

interface WeatherRepository {

    suspend fun getWeather(cityQuery: String) : Resource<WeatherResponse>


}