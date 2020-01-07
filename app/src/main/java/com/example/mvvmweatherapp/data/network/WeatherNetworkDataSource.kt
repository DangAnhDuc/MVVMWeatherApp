package com.example.mvvmweatherapp.data.network

import androidx.lifecycle.LiveData
import com.example.mvvmweatherapp.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val  downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )
}