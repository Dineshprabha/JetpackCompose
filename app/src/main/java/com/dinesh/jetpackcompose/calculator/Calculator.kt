package com.dinesh.jetpackcompose.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun Calculator() {

    var value1 by rememberSaveable {
        mutableStateOf("")
    }
    var value2 by rememberSaveable {
        mutableStateOf("")
    }

    var result by rememberSaveable {
        mutableStateOf("0")
    }
    
    Column (Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )   {
        TextField(value = value1, onValueChange = {
            value1 = it
        },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(value = value2, onValueChange = {
            value2 = it
        },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Row {
            Button(onClick = {
                result = (value1.toInt() + value2.toInt()).toString()
            }) {
                Text(text = "Add")
            }
            Spacer(modifier = Modifier.width(5.dp))
            Button(onClick = {
                result = (value1.toInt() - value2.toInt()).toString()
            }) {
                Text(text = "Sub")
            }
            Spacer(modifier = Modifier.width(5.dp))
            Button(onClick = {
                result = (value1.toInt() * value2.toInt()).toString()
            }) {
                Text(text = "Mul")
            }
            Spacer(modifier = Modifier.width(5.dp))
            Button(onClick = {
                result = (value1.toInt() / value2.toInt()).toString()
            }) {
                Text(text = "Div")
            }
        }

        Text(text = "Result $result")
    }
}