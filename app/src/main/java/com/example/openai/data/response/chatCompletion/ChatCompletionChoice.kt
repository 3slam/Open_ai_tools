package com.example.openai.data.response.chatCompletion



data class ChatCompletionChoice(
    val index: Int,
    val message: AssistantMessage,
    val finish_reason: String
)