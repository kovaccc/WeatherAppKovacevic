package com.example.wheatherappkovacevic.data.models

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @field:SerializedName("weather") val weather: List<Weather>, // [] array in json
    @field:SerializedName("main") val main: MutableMap<String, Double>,
    @field:SerializedName("wind") val wind: MutableMap<String, Double>,
    @field:SerializedName("id") val id: String,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("cod") val cod: Int
)


