package com.example.openai.data.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}