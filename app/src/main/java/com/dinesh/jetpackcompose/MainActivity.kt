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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dinesh.jetpackcompose.bluetooth_chat_app.presentation.BluetoothViewModel
import com.dinesh.jetpackcompose.bluetooth_chat_app.presentation.components.DeviceScreen
import com.dinesh.jetpackcompose.bottom_nav_bar.MainScreen
import com.dinesh.jetpackcompose.bottom_nav_using_screens.MyBottomAppBar
import com.dinesh.jetpackcompose.ui.theme.JetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                ButtonScreen(context = this)
            }
        }
    }


    @Composable
    fun WelcomeScreen() {
        Text(text = "Hello, Jetpack Compose!", fontSize = 24.sp)
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewWelcomeScreen() {
        WelcomeScreen()
    }

}




