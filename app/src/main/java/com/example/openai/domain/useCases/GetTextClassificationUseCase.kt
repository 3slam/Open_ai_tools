package com.example.openai.domain.useCases

import com.example.openai.domain.repo.OpenAiToolsRepository
import javax.inject.Inject

class GetTextClassificationUseCase  @Inject constructor(
    private val openAiToolsRepository: OpenAiToolsRepository
) {

    suspend operator fun invoke(input : String) = openAiToolsRepository.getTextClassification(input)
}