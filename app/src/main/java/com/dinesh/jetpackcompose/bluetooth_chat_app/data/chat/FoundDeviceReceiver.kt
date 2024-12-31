package com.dinesh.jetpackcompose.bluetooth_chat_app.data.chat

import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import com.dinesh.jetpackcompose.bluetooth_chat_app.domain.chat.BluetoothDeviceModel

class FoundDeviceReceiver(
    private val onDeviceFound: (BluetoothDeviceModel) -> Unit,
) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            BluetoothDevice.ACTION_FOUND -> {
                val device = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    intent.getParcelableExtra(BluetoothDevice.EXTRA_NAME, BluetoothDeviceModel::class.java)
                } else {
                    intent.getParcelableExtra(BluetoothDevice.EXTRA_NAME)
                }
                device?.let(onDeviceFound)
            }
        }
    }
}



















