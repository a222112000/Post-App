package com.example.apiapp.repository

import com.example.apiapp.model.Chapter
import com.example.apiapp.model.ChaptersItem
import com.example.apiapp.retrofit.ChapterApi
import com.example.apiapp.retrofit.NetworkMapper
import com.example.apiapp.room.CacheMaper
import com.example.apiapp.room.ChapterDao
import com.example.apiapp.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MainRepo constructor(
    private val chapterDao: ChapterDao,
    private val apiChapter: ChapterApi,
    private val cacheMapper: CacheMaper,
    private val networkMapper: NetworkMapper
) {

    suspend fun getChapters(): Flow<DataState<List<Chapter>>> = flow{
        emit(DataState.Loading)
        try {
            val api = apiChapter.getAllChapters()
            val chapters = networkMapper.mapFromEntutyList(api)
            for(post in chapters){
                chapterDao.insert(cacheMapper.mapToEntity(post))
            }
            val cachedPosts = chapterDao.get()
            emit(DataState.Success(cacheMapper.mapfromEntityList(cachedPosts)))
        }catch (e: Throwable){
            emit(DataState.Error(e))
        }
    }
}