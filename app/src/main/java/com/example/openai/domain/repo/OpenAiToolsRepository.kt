package com.example.openai.domain.repo

import android.net.Uri
import com.example.openai.data.response.textClassification.ModerationResponse
import com.example.openai.domain.model.Image
import com.example.openai.domain.model.Message
import com.example.openai.domain.model.TextClassification


interface OpenAiToolsRepository {

    suspend fun getAnswer(question : String) : Message
    suspend fun generateImage (description :String) : Image
    suspend fun getTextClassification(input : String): List<TextClassification>

}