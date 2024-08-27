package com.dinesh.jetpackcompose

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.dinesh.jetpackcompose.bluetooth_chat_app.presentation.BluetoothViewModel
import com.dinesh.jetpackcompose.bluetooth_chat_app.presentation.components.DeviceScreen
import com.dinesh.jetpackcompose.ui.theme.JetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//            val weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
//            val toDoViewModel = ViewModelProvider(this)[ToDoViewModel::class.java]
//            val chatViewModel = ViewModelProvider(this)[ChatViewModel::class.java]
            JetpackComposeTheme {
                ButtonScreen(this)
            }
        }

    }
}


