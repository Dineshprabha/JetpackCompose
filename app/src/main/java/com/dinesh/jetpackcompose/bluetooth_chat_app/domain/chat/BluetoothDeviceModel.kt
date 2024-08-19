package com.dinesh.jetpackcompose.bluetooth_chat_app.domain.chat

typealias BluetoothDeviceDomain = BluetoothDeviceModel

data class BluetoothDeviceModel(
    val name: String?,
    val address : String,

) {
    fun toBluetoothDeviceDomain(): BluetoothDeviceDomain {
        return BluetoothDeviceDomain(
            name = name,
            address = address
        )
    }
}