package com.dinesh.jetpackcompose.login_signup.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {

    Box {
        Column {
            TextField(
                value = "Hey There.",
                onValueChange = {}
            )
        }
    }
}