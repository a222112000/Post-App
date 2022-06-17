package com.example.apiapp.di

import android.content.Context
import androidx.room.Room
import com.example.apiapp.room.ChapterDao
import com.example.apiapp.room.PostsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun providedChapterDB(@ApplicationContext context: Context): PostsDatabase{
        return Room.databaseBuilder(
            context,
            PostsDatabase::class.java,
            PostsDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providePostsDao(postsDatabase: PostsDatabase): ChapterDao{
        return postsDatabase.chapterDao()
    }

}