package com.example.openai.data.mapper

import com.example.openai.data.response.imageGenerator.GenerationImageResponse
import com.example.openai.domain.model.Image
import com.example.openai.utilites.RECEIVER

object ToImageMapper :Mapper<GenerationImageResponse,Image> {
    override fun map(input: GenerationImageResponse): Image {
        return Image(input.data[0].url,"", RECEIVER)
    }
}