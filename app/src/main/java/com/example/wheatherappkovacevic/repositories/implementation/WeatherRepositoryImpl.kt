package com.example.wheatherappkovacevic.repositories.implementation

import android.util.Log
import com.example.wheatherappkovacevic.data.WeatherSource
import com.example.wheatherappkovacevic.data.models.WeatherResponse
import com.example.wheatherappkovacevic.repositories.WeatherRepository
import com.example.wheatherappkovacevic.utils.Resource
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import javax.inject.Inject


private const val TAG = "WeatherRepositoryImpl"
class WeatherRepositoryImpl @Inject constructor (private val weatherSource: WeatherSource) : WeatherRepository {

    override suspend fun getWeather(cityQuery: String): Resource<WeatherResponse> {
        Log.d(TAG, "getWeather: starts")

        val result = withContext(IO){weatherSource.loadWeather(cityQuery)} // in background thread, I/O dispatcher

        Log.d(TAG, "getWeather: ends with $result")

        return result
    }

}