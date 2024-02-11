package com.onlineclass.onlineclassapp.service

import com.onlineclass.onlineclassapp.model.Class
import com.onlineclass.onlineclassapp.repository.ClassRepository
import org.springframework.stereotype.Service

@Service
class ClassService(private val classRepository: ClassRepository) {

    fun getClassList(ids: List<Long>): List<Class> {
        val classList = ArrayList<Class>()
        ids.forEach { classList.add(classRepository.findById(it).orElse(null)) }
        return classList
    }

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
}