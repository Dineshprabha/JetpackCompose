package com.dinesh.jetpackcompose.bluetooth_chat_app.di

import android.content.Context
import com.dinesh.jetpackcompose.bluetooth_chat_app.data.chat.AndroidBluetoothController
import com.dinesh.jetpackcompose.bluetooth_chat_app.domain.chat.BluetoothController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBluetoothController(@ApplicationContext context: Context): BluetoothController {
        return AndroidBluetoothController(context)
    }
}