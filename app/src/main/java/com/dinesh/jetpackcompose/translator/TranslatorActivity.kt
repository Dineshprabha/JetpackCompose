package com.dinesh.jetpackcompose.translator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dinesh.jetpackcompose.translator.screens.TranslatorScreen
import com.dinesh.jetpackcompose.translator.ui.theme.JetpackComposeTheme

class TranslatorActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeTheme {
                TranslatorScreen()
            }
        }
    }
}



