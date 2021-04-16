package com.example.wheatherappkovacevic.di

import com.example.wheatherappkovacevic.api.WeatherService
import com.example.wheatherappkovacevic.utils.ResponseHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideWeatherService(): WeatherService {
        return WeatherService.create()
    }


    @Provides
    fun provideResponseHandler() = ResponseHandler()
}