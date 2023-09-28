package com.example.openai.ui.home

import androidx.lifecycle.viewModelScope
import com.example.openai.ui.base.BaseViewModel
import com.example.openai.ui.chat.ChatUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel :BaseViewModel() , HomeInteraction{

    private val  _effect    =  MutableSharedFlow<HomeUiEffect>()
    val  effect = _effect.asSharedFlow()

    override fun onClickGoToChat()= sendUiEffect(HomeUiEffect.NavigateToChat)
    override fun onClickGoToImageGeneration()= sendUiEffect(HomeUiEffect.NavigateToImageGeneration)
    override fun onClickGoToTextClassification()= sendUiEffect(HomeUiEffect.NavigateToTextClassification)

    private fun sendUiEffect(uiEffect: HomeUiEffect) {
        viewModelScope.launch(Dispatchers.IO) {
            _effect.emit(uiEffect)
        }
    }
}