package com.example.openai.ui.image

 import androidx.lifecycle.viewModelScope
 import com.example.openai.domain.model.Image
 import com.example.openai.domain.useCases.GenerateImageUseCase
 import com.example.openai.ui.base.BaseViewModel
 import com.example.openai.utilites.SENDER


 import dagger.hilt.android.lifecycle.HiltViewModel
 import kotlinx.coroutines.flow.MutableStateFlow
 import kotlinx.coroutines.flow.asStateFlow
 import kotlinx.coroutines.flow.update
 import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageGeneratorViewModel @Inject constructor(
    private val useCase: GenerateImageUseCase
) : BaseViewModel() {


    private val  _state   = MutableStateFlow(ImageUiState())
    val state =  _state.asStateFlow()

    private fun getAnswer (question:String) = viewModelScope.launch {


        _state.update { it.copy(
            isEmpty = false,
            isGenerate = true,
            list = _state.value.list + listOf(Image("",question, SENDER)),
            question = ""
        )}
        val result = useCase(question)
        _state.update { it.copy(list = _state.value.list + listOf (result) ) }
        _state.update { it.copy(isGenerate = false ) }
    }

    fun onClickSend() = getAnswer(_state.value.question)

    fun onQuestionInputChange(question: CharSequence)= _state.update { it.copy(question = question.toString()) }

}