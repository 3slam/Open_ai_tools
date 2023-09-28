package com.example.openai.data.remote


import com.example.openai.data.request.ModerationRequest
import com.example.openai.data.response.textClassification.ModerationResponse
import com.example.openai.data.request.ChatCompletionRequest
import com.example.openai.data.response.chatCompletion.ChatCompletionResponse
import com.example.openai.data.request.GenerationImageRequest
import com.example.openai.data.response.imageGenerator.GenerationImageResponse

import retrofit2.http.Body
import retrofit2.http.POST

interface OpenAiServiceTools {


     @POST("chat/completions")
    suspend fun getChatCompletion(
         @Body requestBody: ChatCompletionRequest
    ): ChatCompletionResponse



     @POST("images/generations")
    suspend fun getImage(
         @Body requestBody: GenerationImageRequest
     ): GenerationImageResponse


    @POST("moderations")
    suspend fun getTextClassification(
        @Body requestBody: ModerationRequest
    ): ModerationResponse
}
