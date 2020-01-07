package com.example.mvvmweatherapp.data.repository

import androidx.lifecycle.LiveData
import com.example.mvvmweatherapp.data.db.CurrentWeatherDao
import com.example.mvvmweatherapp.data.db.entity.CurrentWeatherEntry
import com.example.mvvmweatherapp.data.network.WeatherNetworkDataSource
import com.example.mvvmweatherapp.data.network.response.CurrentWeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ForecastRepositoryImpl(
    private val currentWeatherDao: CurrentWeatherDao,
    private val weatherNetworkDataSource: WeatherNetworkDataSource
) : ForecastRepository {
    init {
        weatherNetworkDataSource.downloadedCurrentWeather.observeForever{newCurrentWeather ->
            presistFFetchedCurrentWeather(newCurrentWeather)
        }
    }
    override suspend fun getCurrentWeather(): LiveData<CurrentWeatherEntry> {
        return withContext(Dispatchers.IO){
            return@withContext currentWeatherDao.getWeather()
        }
    }
    private fun presistFFetchedCurrentWeather(fetchedWeather: CurrentWeatherResponse){
        GlobalScope.launch(Dispatchers.IO) {
            currentWeatherDao.upsert(fetchedWeather.currentWeatherEntry)
        }
    }
}