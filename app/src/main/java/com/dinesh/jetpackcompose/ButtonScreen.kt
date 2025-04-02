package com.dinesh.jetpackcompose

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat.startActivity
import com.dinesh.jetpackcompose.animations.AnimationActivity
import com.dinesh.jetpackcompose.biometric_auth.BioMetricAuthActivity
import com.dinesh.jetpackcompose.bluetooth_chat_app.BluetoothAppActivity
import com.dinesh.jetpackcompose.bottom_nav_using_screens.BottomAppBarActivity
import com.dinesh.jetpackcompose.floating_bottom_nav_bar.FloatingBottomNavActivity
import com.dinesh.jetpackcompose.gemini_chat_bot.GeminiChatActivity
import com.dinesh.jetpackcompose.nested_list_with_checkbox.CheckBoxActivity
import com.dinesh.jetpackcompose.painting.PaintActivity
import kotlinx.coroutines.launch

@Composable
fun ButtonScreen(
    context: Context
) {


    var counter by remember {
        mutableStateOf(0)
    }

    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = false) {
        scope.launch {
            Toast.makeText(context, "Button Screen", Toast.LENGTH_SHORT).show()
        }
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, BluetoothAppActivity::class.java)
                startActivity(context, intent, null)

        }) {
            Text(text = "Open Bluetooth Activity")
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, CheckBoxActivity::class.java)
                startActivity(context, intent, null)

            }) {
            Text(text = "Open Nested Checkbox Activity")
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, GeminiChatActivity::class.java)
                startActivity(context, intent, null)

            }) {
            Text(text = "Gemini Chat Bot")
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, PaintActivity::class.java)
                startActivity(context, intent, null)

            }) {
            Text(text = "Paint")
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, BottomAppBarActivity::class.java)
                startActivity(context, intent, null)

            }) {
            Text(text = "MyBottomAppBar")
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, FloatingBottomNavActivity::class.java)
                startActivity(context, intent, null)

            }) {
            Text(text = "Floating Nav Bar")
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, AnimationActivity::class.java)
                startActivity(context, intent, null)

            }) {
            Text(text = "Animation")
        }


        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, BioMetricAuthActivity::class.java)
                startActivity(context, intent, null)

            }) {
            Text(text = "BioMetric Auth")
        }

    }
}