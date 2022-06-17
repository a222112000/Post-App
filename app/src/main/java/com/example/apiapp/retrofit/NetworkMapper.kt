package com.example.apiapp.retrofit

import com.example.apiapp.model.Chapter
import com.example.apiapp.model.Chapters
import com.example.apiapp.model.ChaptersItem
import com.example.apiapp.util.EntityMapper
import javax.inject.Inject

class NetworkMapper @Inject constructor(): EntityMapper<ChaptersItem, Chapter> {
    override fun mapfromEntity(entity: ChaptersItem): Chapter {
        return  Chapter(body = entity.body,
            id = entity.id,
            title = entity.title,
            userId = entity.userId)
    }

    override fun mapToEntity(domainModel: Chapter): ChaptersItem {
        return ChaptersItem(body = domainModel.body,
            id = domainModel.id,
            title = domainModel.title,
            userId = domainModel.userId)
    }

    fun mapFromEntutyList(entities: List<ChaptersItem>):List<Chapter>{
        return entities.map { mapfromEntity(it) }
    }

}