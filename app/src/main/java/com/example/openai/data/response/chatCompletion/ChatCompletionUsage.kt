package com.example.openai.data.response.chatCompletion


data class ChatCompletionUsage(
    val prompt_tokens: Int,
    val completion_tokens: Int,
    val total_tokens: Int
)