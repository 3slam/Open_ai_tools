package com.example.openai.ui.textClassification

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.openai.domain.model.Message
import com.example.openai.domain.model.TextClassification
import com.example.openai.domain.useCases.GetTextClassificationUseCase
import com.example.openai.ui.base.BaseViewModel
import com.example.openai.ui.home.HomeUiEffect
import com.example.openai.utilites.SENDER


import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TextClassificationViewModel @Inject constructor(
    private val useCase: GetTextClassificationUseCase
) : BaseViewModel() {

    private val  _state   =  MutableStateFlow(TextClassificationUiState())
    val   state = _state.asStateFlow()

    private fun getAnswer () = viewModelScope.launch {
        _state.update { it.copy(  isEmpty = false,isLoading = true, text = _state.value.question , question = "")}
         _state.update { it.copy(list = useCase(_state.value.question))}
        _state.update { it.copy(isLoading = false , isSuccess = true ) }

    }

    fun onClickSend() = getAnswer()
    fun onQuestionInputChange(question:CharSequence)= _state.update { it.copy(  question = question.toString() ) }

}

