package com.example.openai.ui.chat

import androidx.lifecycle.viewModelScope
import com.example.openai.domain.model.Message
import com.example.openai.domain.useCases.ChatCompletionUseCase
import com.example.openai.ui.base.BaseViewModel
import com.example.openai.utilites.SENDER


import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatCompletionViewModel @Inject constructor(
    private val useCase: ChatCompletionUseCase
) : BaseViewModel() {

    private val  _state   = MutableStateFlow(ChatUiState())
    val state =  _state.asStateFlow()
     private fun getAnswer (question :String) = viewModelScope.launch {
            _state.update { it.copy(
                isEmpty = false,
                isTyping = true,
                list = _state.value.list + listOf(Message(question , SENDER)))}
             val result = useCase(question)
            _state.update { it.copy(list = _state.value.list + listOf(result)) }
            _state.update { it.copy(isTyping = false ) }
    }

    fun onClickSend() {
        getAnswer( _state.value.question)
        _state.update {
            it.copy(
                question =""
            )
        }
    }

    fun onQuestionInputChange(question: CharSequence) {
        _state.update {
            it.copy(question = question.toString()) }
    }
}

