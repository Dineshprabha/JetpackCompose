package com.dinesh.jetpackcompose.calculator

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CalculatorButton(
    modifier: Modifier = Modifier,
    name : String,
) {
    Button(onClick = {

    }) {
        Text(text = name)
    }

}