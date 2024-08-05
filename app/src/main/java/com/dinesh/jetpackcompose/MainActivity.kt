package com.dinesh.jetpackcompose

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.dinesh.jetpackcompose.todo.ToDoViewModel
import com.dinesh.jetpackcompose.weatherapp.WeatherViewModel

class MainActivity : ComponentActivity() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
            val toDoViewModel = ViewModelProvider(this)[ToDoViewModel::class.java]
            MyNavigation(toDoViewModel)

        }
    }
}
