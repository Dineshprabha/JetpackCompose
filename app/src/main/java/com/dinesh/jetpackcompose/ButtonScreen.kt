package com.dinesh.jetpackcompose

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat.startActivity
import com.dinesh.jetpackcompose.bluetooth_chat_app.BluetoothAppActivity
import com.dinesh.jetpackcompose.nested_list_with_checkbox.CheckBoxActivity

@Composable
fun ButtonScreen(
    context: Context
) {

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
                val intent = Intent(context, BluetoothAppActivity::class.java)
                startActivity(context, intent, null)

            }) {
            Text(text = "Open Bluetooth Activity")
        }

    }
}