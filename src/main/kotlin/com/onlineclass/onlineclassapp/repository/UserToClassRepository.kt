package com.onlineclass.onlineclassapp.repository

import com.onlineclass.onlineclassapp.model.UserToClass
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserToClassRepository : CrudRepository<UserToClass, Long> {
    fun findAllByUserId(id: Long): List<UserToClass>
}