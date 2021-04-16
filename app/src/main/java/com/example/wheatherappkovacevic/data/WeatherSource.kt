package com.example.wheatherappkovacevic.data

import com.example.wheatherappkovacevic.api.WeatherService
import com.example.wheatherappkovacevic.data.models.WeatherResponse
import com.example.wheatherappkovacevic.utils.Resource
import com.example.wheatherappkovacevic.utils.ResponseHandler

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherSource @Inject constructor(private val weatherService: WeatherService, private val responseHandler: ResponseHandler) {

    suspend fun loadWeather(city: String) : Resource<WeatherResponse> {

        return try {
           responseHandler.handleSuccess(weatherService.searchWeather(city))
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

}