package com.dinesh.jetpackcompose.weatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dinesh.jetpackcompose.weatherapp.model.WeatherModel

class WeatherRepository (
    private val weatherAPI: WeatherAPI
) {
    private val _weatherData = MutableLiveData<WeatherModel>()
    val weatherData : LiveData<WeatherModel> = _weatherData



}