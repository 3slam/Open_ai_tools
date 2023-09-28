package com.example.openai.data.response.chatCompletion


data class ChatCompletionResponse(
    val id: String,
    val `object`: String,
    val created: Long,
    val choices: List<ChatCompletionChoice>,
    val usage: ChatCompletionUsage
)
