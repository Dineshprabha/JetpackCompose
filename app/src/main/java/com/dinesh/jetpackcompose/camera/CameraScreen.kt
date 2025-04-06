package com.dinesh.jetpackcompose.camera

import android.content.Context
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun CameraScreen(modifier: Modifier = Modifier, context: Context) {

    val cameraController = remember {
        LifecycleCameraController(context)
    }

    
}