package com.dinesh.jetpackcompose.list_demo

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ListDemo(modifier: Modifier = Modifier) {
    Column {
        for (i in 1 .. 5){
            Text(text = "Item $i")
        }
    }
}