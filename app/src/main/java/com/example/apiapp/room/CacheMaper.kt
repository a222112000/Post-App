package com.example.apiapp.room

import com.example.apiapp.model.Chapter
import com.example.apiapp.retrofit.NetworkMapper
import com.example.apiapp.util.EntityMapper
import javax.inject.Inject


class CacheMaper @Inject constructor():
    EntityMapper<chapterCacheEntity, Chapter> {
    override fun mapfromEntity(entity: chapterCacheEntity): Chapter {
        return Chapter(body =entity.body,
            id =  entity.id,
            title = entity.title,
            userId = entity.userId
        )
    }

    override fun mapToEntity(domainModel: Chapter): chapterCacheEntity {
        return chapterCacheEntity(body =domainModel.body,
            id =  domainModel.id,
            title = domainModel.title,
            userId = domainModel.userId
        )
    }
    fun mapfromEntityList(entity: List<chapterCacheEntity>):List<Chapter>{
        return entity.map { mapfromEntity(it) }
    }
}