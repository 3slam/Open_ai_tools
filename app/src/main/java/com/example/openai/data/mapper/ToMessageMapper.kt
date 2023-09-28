package com.example.openai.data.mapper

import com.example.openai.data.response.chatCompletion.ChatCompletionResponse
import com.example.openai.domain.model.Message
import com.example.openai.utilites.RECEIVER

object ToMessageMapper :Mapper<ChatCompletionResponse,Message> {
    override fun map(input: ChatCompletionResponse): Message {
         return  Message(input.choices[0].message.content , RECEIVER)
    }
}