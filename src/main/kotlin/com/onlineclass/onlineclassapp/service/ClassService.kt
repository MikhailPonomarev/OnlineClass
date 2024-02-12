package com.onlineclass.onlineclassapp.service

import com.onlineclass.onlineclassapp.model.Class
import com.onlineclass.onlineclassapp.repository.ClassRepository
import com.onlineclass.onlineclassapp.repository.UserToClassRepository
import org.springframework.stereotype.Service

@Service
class ClassService(
    private val classRepository: ClassRepository,
    private val userToClassRepository: UserToClassRepository
) {
    fun createClass(clazz: Class): Class = classRepository.save(clazz)

    fun updateClass(clazz: Class): Class = classRepository.save(clazz)

    fun archiveClass(id: Long): Class {
        val classToArchive = classRepository.findById(id).get()
        classToArchive.isActive = false
        return classRepository.save(classToArchive)
    }

    fun restoreClass(id: Long): Class {
        val classToArchive = classRepository.findById(id).get()
        classToArchive.isActive = true
        return classRepository.save(classToArchive)
    }

    fun getActiveClassesByUserId(userId: Long): List<Class> {
        return classRepository.findClassesByIds(
            userToClassRepository.findClassesByUserId(userId).map { it!!.classId!! }
        )
    }
}