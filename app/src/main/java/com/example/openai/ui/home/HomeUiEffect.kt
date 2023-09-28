package com.example.openai.ui.home

sealed interface HomeUiEffect   {
      object NavigateToChat : HomeUiEffect
      object NavigateToImageGeneration : HomeUiEffect
      object NavigateToTextClassification : HomeUiEffect
}