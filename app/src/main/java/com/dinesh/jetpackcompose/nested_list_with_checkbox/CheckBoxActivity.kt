package com.dinesh.jetpackcompose.nested_list_with_checkbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dinesh.jetpackcompose.RestApiFakerStore.presentation.screens.ProductsScreen
import com.dinesh.jetpackcompose.nested_list_with_checkbox.ui.theme.JetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckBoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeTheme {
                ProductsScreen()
            }
        }
    }
}

