package com.example.openai.data.response.textClassification

data class ModerationResponse(
    val id: String,
    val model: String,
    val results: List<Result>
)