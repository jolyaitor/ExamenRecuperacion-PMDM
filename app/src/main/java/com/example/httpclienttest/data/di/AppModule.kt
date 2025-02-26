package com.example.httpclienttest.data.di

import com.example.httpclienttest.data.repositories.PostsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePostsRepository(): PostsRepository {
        return PostsRepository()
    }

}