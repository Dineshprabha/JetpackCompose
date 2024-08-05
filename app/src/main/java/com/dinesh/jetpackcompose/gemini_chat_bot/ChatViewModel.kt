package com.dinesh.jetpackcompose.gemini_chat_bot

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    val messageList by lazy {
        mutableStateListOf<Message>()
    }

    val generativeModel : GenerativeModel = GenerativeModel(
        modelName = "gemini-1.5-flash",
        apiKey = Constants.APIKEY
    )

    fun sendMessage(question : String) {
        try {
            viewModelScope.launch {
                val prompt = generativeModel.startChat(
                    history = messageList.map {
                        content(it.role){
                            text(it.message)
                        }
                    }.toList()
                )

                messageList.add(Message(question, "user"))
                messageList.add(Message("Typing...", "model"))
                val response = prompt.sendMessage(question)
                messageList.removeLast()
                messageList.add(Message(response.text.toString(), "model"))

            }

        }catch (e: Exception){
            messageList.removeLast()
            messageList.add(Message("Error : "+e.message.toString(), "model"))
        }

    }
}