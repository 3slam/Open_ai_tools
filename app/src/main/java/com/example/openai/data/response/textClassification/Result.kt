package com.example.openai.data.response.textClassification

data class Result(
    val categories: Categories,
    val category_scores: CategoryScores,
    val flagged: Boolean
)