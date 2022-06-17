package com.example.apiapp.di

import com.example.apiapp.repository.MainRepo
import com.example.apiapp.retrofit.ChapterApi
import com.example.apiapp.retrofit.NetworkMapper
import com.example.apiapp.room.CacheMaper
import com.example.apiapp.room.ChapterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepo(
        chapterDao: ChapterDao,
        api: ChapterApi,
        cacheMaper: CacheMaper,
        networkMapper: NetworkMapper
    ): MainRepo{
        return MainRepo(chapterDao,api,cacheMaper,networkMapper)
    }
}