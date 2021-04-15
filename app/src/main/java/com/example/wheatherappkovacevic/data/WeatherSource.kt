package com.example.wheatherappkovacevic.data

import com.example.wheatherappkovacevic.api.WeatherService
import com.example.wheatherappkovacevic.data.models.WeatherResponse

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherSource @Inject constructor(private val weatherService: WeatherService) {

    suspend fun loadWeather(city: String) : WeatherResponse {

        return weatherService.searchWeather(city)

//        } catch (exception: Exception) {
//
//            Log.e("Connectivity", "No internet connection.", exception)
//
//            return null
//        }
    }


}