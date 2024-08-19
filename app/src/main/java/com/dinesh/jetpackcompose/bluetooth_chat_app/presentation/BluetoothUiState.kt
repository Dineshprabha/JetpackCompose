package com.dinesh.jetpackcompose.bluetooth_chat_app.presentation

import com.dinesh.jetpackcompose.bluetooth_chat_app.domain.chat.BluetoothDeviceModel


data class BluetoothUiState(
    val scannedDevices: List<BluetoothDeviceModel> = emptyList(),
    val pairedDevices: List<BluetoothDeviceModel> = emptyList(),
)