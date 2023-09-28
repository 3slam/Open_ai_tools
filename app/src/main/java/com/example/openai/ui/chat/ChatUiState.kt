package com.example.openai.ui.chat

import com.example.openai.domain.model.Message

data class ChatUiState(
    val question: String = "",
    val text:String = "",
    val list : List<Message>  = emptyList(),
    val isTyping : Boolean = false ,
    val isEmpty : Boolean = true
)