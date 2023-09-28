package com.example.openai.data.repoImpl


import com.example.openai.data.mapper.ToTextClassificationMapper
import com.example.openai.data.mapper.ToImageMapper
import com.example.openai.data.mapper.ToMessageMapper
import com.example.openai.data.remote.OpenAiServiceTools
import com.example.openai.data.request.ModerationRequest
 import com.example.openai.data.request.ChatCompletionRequest
import com.example.openai.data.request.MessageRequest
import com.example.openai.data.request.GenerationImageRequest
import com.example.openai.domain.model.Image
import com.example.openai.domain.model.Message
import com.example.openai.domain.model.TextClassification
import com.example.openai.domain.repo.OpenAiToolsRepository
import com.example.openai.utilites.CHAT_API_MODEL
import retrofit2.Response
import javax.inject.Inject

class OpenAiToolsRepositoryImpl @Inject constructor(
    private val openAiServiceTools: OpenAiServiceTools
) : OpenAiToolsRepository {
    override suspend fun getAnswer(question: String): Message {

        val requestBody = ChatCompletionRequest(CHAT_API_MODEL, listOf(MessageRequest("user", question)))
        return try {
            ToMessageMapper.map(openAiServiceTools.getChatCompletion(requestBody))
        }catch (e:Exception){
            throw Exception(e.message.toString())
        }
    }

    override suspend fun generateImage(description: String): Image {
        val requestBody = GenerationImageRequest(description , 1 ,"1024x1024")
        return try {
           ToImageMapper.map( openAiServiceTools.getImage(requestBody))
        }catch (e:Exception) {
             throw Exception(e.message.toString())
        }
    }

    override suspend fun getTextClassification(input: String): List<TextClassification> {
          try {
           return ToTextClassificationMapper.map(openAiServiceTools.getTextClassification(ModerationRequest(input)))
        }catch (e:Exception) {
           throw Exception(e.message)
        }
    }


}