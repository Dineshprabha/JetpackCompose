package com.dinesh.jetpackcompose.gemini_chat_bot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dinesh.jetpackcompose.ui.theme.Purple40

@Composable
fun ChatPage(modifier: Modifier = Modifier, chatViewModel: ChatViewModel) {
    Column {
        AppBar()

        MessageList(modifier = Modifier.weight(1f), messageList = chatViewModel.messageList)
        MessageInput(onMessageSend = {
            chatViewModel.sendMessage(it)
        })
    }
}


@Composable
fun MessageList(modifier: Modifier = Modifier, messageList: List<Message>) {
    LazyColumn(
        modifier = modifier,
        reverseLayout = true
    ) {
        items(messageList.reversed()) {
            MessageRow(it)
        }
    }
}


@Composable
fun MessageRow(message: Message) {
    val isModel = message.role == "model"

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box (
                modifier = Modifier.align(
                    if(isModel) Alignment.BottomStart else Alignment.BottomEnd
                ).padding(
                    start = if (isModel) 8.dp else 70.dp,
                    end = if(isModel) 70.dp else 8.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
                    .clip(RoundedCornerShape(48f))
                    .background(if (isModel) Purple40 else Color.Gray)
                    .padding(16.dp)
            ) {
                Text(text = message.message, fontWeight = FontWeight.W500, color = Color.White)
            }

        }


    }
}


@Composable
fun MessageInput(onMessageSend: (String) -> Unit) {

    var message by remember {
        mutableStateOf("")
    }

    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        OutlinedTextField(
            modifier = Modifier.weight(1f),
            value = message,
            onValueChange = {
                message = it
            })
        IconButton(onClick = {
            if (message.isNotEmpty()){
                onMessageSend(message)
                message = ""
            }

        }) {
            Icon(imageVector = Icons.Default.Send, contentDescription = "send")
        }

    }
}

@Composable
fun AppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.primary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Gemini Chat Bot",
            modifier = Modifier.padding(16.dp),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,

            )
    }
}