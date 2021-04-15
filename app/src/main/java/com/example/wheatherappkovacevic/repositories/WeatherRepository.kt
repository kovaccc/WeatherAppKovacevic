package com.example.wheatherappkovacevic.repositories

import com.example.wheatherappkovacevic.data.models.WeatherResponse

interface WeatherRepository {

    suspend fun getWeather(cityQuery: String) : WeatherResponse


}