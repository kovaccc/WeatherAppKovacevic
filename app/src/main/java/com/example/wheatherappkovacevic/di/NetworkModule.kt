package com.example.wheatherappkovacevic.di

import com.example.wheatherappkovacevic.api.WeatherService
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
    fun provideUnsplashService(): WeatherService {
        return WeatherService.create()
    }
}