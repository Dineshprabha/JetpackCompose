package com.dinesh.jetpackcompose.weatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinesh.jetpackcompose.weatherapp.model.WeatherModel
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val weatherAPI = RetrofitInstance.weatherAPI

    private val _weatherData = MutableLiveData<NetworkResult<WeatherModel>>()
    val weatherData: LiveData<NetworkResult<WeatherModel>> = _weatherData

    fun getData(city: String) {
        _weatherData.value = NetworkResult.Loading()
        try {
            viewModelScope.launch {
                val response = weatherAPI.getWeather(WeatherConstants.API_KEY, city)
                if (response.isSuccessful) {
                    response.body()?.let {
                        _weatherData.value = NetworkResult.Success(it)
                    }
                } else {
                    _weatherData.value = NetworkResult.Error("Failed to load data")
                }
            }

        } catch (e: Exception) {
            _weatherData.value = NetworkResult.Error("Failed to load data")
        }

    }
}