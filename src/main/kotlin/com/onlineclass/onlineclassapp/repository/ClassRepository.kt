package com.onlineclass.onlineclassapp.repository

import com.onlineclass.onlineclassapp.model.Class
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClassRepository : CrudRepository<Class, Long> {
    @Query("FROM Class c WHERE c.id IN (:ids)")
    fun findClassesByIds(ids: List<Long>): List<Class>
}