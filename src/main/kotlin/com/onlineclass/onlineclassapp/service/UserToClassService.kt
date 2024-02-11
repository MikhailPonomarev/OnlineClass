package com.onlineclass.onlineclassapp.service

import com.onlineclass.onlineclassapp.model.Class
import com.onlineclass.onlineclassapp.repository.UserToClassRepository
import org.springframework.stereotype.Service

@Service
class UserToClassService(
    private val userToClassRepository: UserToClassRepository,
    private val classService: ClassService
) {
    fun getActiveClassesByUserId(id: Long): List<Class> {
        val classIds = userToClassRepository.findAllByUserId(id).map { it.classId!! }
        return classService.getClassList(classIds).filter { it.isActive == true }
    }
}