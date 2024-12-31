package com.dinesh.jetpackcompose.bluetooth_chat_app.domain.chat

sealed interface ConnectionResult {
    object ConnectionEstablished : ConnectionResult
    data class Error(val message : String) : ConnectionResult
}