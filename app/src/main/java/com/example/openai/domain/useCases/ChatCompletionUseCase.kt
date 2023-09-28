package com.example.openai.domain.useCases

import com.example.openai.domain.repo.OpenAiToolsRepository

import javax.inject.Inject

class ChatCompletionUseCase @Inject constructor(
    private val openAiToolsRepository: OpenAiToolsRepository
) {
    suspend operator fun invoke(question :String) = openAiToolsRepository.getAnswer(question)
}