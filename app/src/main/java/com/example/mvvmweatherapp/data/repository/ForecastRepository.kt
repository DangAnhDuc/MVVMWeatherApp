package com.example.mvvmweatherapp.data.repository

import androidx.lifecycle.LiveData
import com.example.mvvmweatherapp.data.db.entity.CurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather():LiveData<CurrentWeatherEntry>
}