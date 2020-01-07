package com.example.mvvmweatherapp.data.network.response


import com.example.mvvmweatherapp.data.db.entity.CurrentWeatherEntry
import com.example.mvvmweatherapp.data.db.entity.Location
import com.example.mvvmweatherapp.data.db.entity.Request
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)