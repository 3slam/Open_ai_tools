package com.example.openai.data.request


data class ChatCompletionRequest(val model: String, val messages: List<MessageRequest>)