package com.dinesh.jetpackcompose.login_signup.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login Page",
            fontStyle = FontStyle.Normal,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Email Address")
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Password")
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {}) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Text(
                text = "Login Page",
                fontStyle = FontStyle.Normal,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = "Create Account",
                fontStyle = FontStyle.Normal,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.clickable {

                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {

        }

    }

}