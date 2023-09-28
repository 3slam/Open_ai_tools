package com.example.openai.ui.image

import com.example.openai.domain.model.Image

data class ImageUiState(
    val question: String = "",
    val list : List<Image>  = emptyList(),
    val isGenerate : Boolean = false ,
    val isEmpty : Boolean = true
)