package com.dinesh.jetpackcompose.gemini_chat_bot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.dinesh.jetpackcompose.gemini_chat_bot.ui.theme.JetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GeminiChatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val chatViewModel = ViewModelProvider(this)[ChatViewModel::class.java]
            JetpackComposeTheme {
                ChatPage(chatViewModel = chatViewModel)
            }
        }
    }
}

