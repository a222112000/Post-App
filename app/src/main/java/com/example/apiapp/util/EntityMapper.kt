package com.example.apiapp.util

interface EntityMapper<Entity,DomainChapter> {
    fun mapfromEntity(entity: Entity):DomainChapter
    fun mapToEntity(domainModel: DomainChapter):Entity
}