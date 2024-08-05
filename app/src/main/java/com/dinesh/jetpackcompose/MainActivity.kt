package com.dinesh.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.dinesh.jetpackcompose.weatherapp.WeatherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
            MyNavigation(weatherViewModel)

        }
    }
}
