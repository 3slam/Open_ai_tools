package com.example.openai.domain.useCases

import com.example.openai.domain.repo.OpenAiToolsRepository

import javax.inject.Inject

class GenerateImageUseCase @Inject constructor(
    private val openAiToolsRepository: OpenAiToolsRepository
) {
    suspend operator fun invoke(description :String) = openAiToolsRepository.generateImage(description)
}