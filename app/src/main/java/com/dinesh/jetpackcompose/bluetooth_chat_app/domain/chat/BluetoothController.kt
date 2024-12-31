package com.dinesh.jetpackcompose.bluetooth_chat_app.domain.chat

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface BluetoothController {

    val scannedDevices : StateFlow<List<BluetoothDeviceModel>>
    val pairedDevices : StateFlow<List<BluetoothDeviceModel>>

    fun startDiscovery()
    fun stopDiscovery()

    fun startBluetoothServer() : Flow<ConnectionResult>

    fun connectToDevice(device : BluetoothDeviceModel) : Flow<ConnectionResult>

    fun closeConnection()

    fun release()
}