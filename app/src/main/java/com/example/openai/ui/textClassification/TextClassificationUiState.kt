package com.example.openai.ui.textClassification


import com.example.openai.domain.model.TextClassification

data class TextClassificationUiState(
    val question: String = "",
    val text : String = "" ,
    val list : List<TextClassification>  = emptyList(),
    val isLoading : Boolean = false ,
    val isSuccess  : Boolean = false ,
    val isEmpty : Boolean = true
)