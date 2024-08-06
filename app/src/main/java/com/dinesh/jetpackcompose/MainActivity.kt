package com.dinesh.jetpackcompose

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.dinesh.jetpackcompose.bottom_nav_bar.MainScreen
import com.dinesh.jetpackcompose.gemini_chat_bot.ChatPage
import com.dinesh.jetpackcompose.gemini_chat_bot.ChatViewModel
import com.dinesh.jetpackcompose.todo.ToDoViewModel
import com.dinesh.jetpackcompose.ui.theme.JetpackComposeTheme
import com.dinesh.jetpackcompose.weatherapp.WeatherViewModel

class MainActivity : ComponentActivity() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
//            val toDoViewModel = ViewModelProvider(this)[ToDoViewModel::class.java]
//            val chatViewModel = ViewModelProvider(this)[ChatViewModel::class.java]
            JetpackComposeTheme {
                MainScreen()
            }
        }
    }
}

