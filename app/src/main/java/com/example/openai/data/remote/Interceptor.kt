package com.example.openai.data.remote

import com.example.openai.utilites.API_KEY
import com.example.openai.utilites.CONTENT_TYPE
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class Interceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Content-Type", CONTENT_TYPE)
            .addHeader("Authorization", API_KEY)
            .build()
        return chain.proceed(request)
    }
}
