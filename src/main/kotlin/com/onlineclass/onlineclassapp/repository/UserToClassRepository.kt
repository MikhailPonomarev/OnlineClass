package com.onlineclass.onlineclassapp.repository

import com.onlineclass.onlineclassapp.model.UserToClass
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserToClassRepository : CrudRepository<UserToClass, Long> {
    @Query("FROM UserToClass u WHERE u.userId = :userId")
    fun findClassesByUserId(userId: Long): List<UserToClass?>
}