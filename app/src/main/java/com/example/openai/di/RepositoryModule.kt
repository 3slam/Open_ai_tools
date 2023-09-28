package com.example.openai.di



import com.example.openai.data.remote.OpenAiServiceTools
import com.example.openai.data.repoImpl.OpenAiToolsRepositoryImpl
import com.example.openai.domain.repo.OpenAiToolsRepository
import dagger.Binds

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun provideOpenAiToolsRepository( penAiToolsRepositoryImpl: OpenAiToolsRepositoryImpl): OpenAiToolsRepository
}
