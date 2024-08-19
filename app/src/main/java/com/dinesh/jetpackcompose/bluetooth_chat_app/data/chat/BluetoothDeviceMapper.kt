package com.dinesh.jetpackcompose.bluetooth_chat_app.data.chat

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import com.dinesh.jetpackcompose.bluetooth_chat_app.domain.chat.BluetoothDeviceDomain

@SuppressLint("MissingPermission")
fun BluetoothDevice.toBluetoothDeviceDomain() : BluetoothDeviceDomain {
    return BluetoothDeviceDomain(
        name = name,
        address = address
    )
}