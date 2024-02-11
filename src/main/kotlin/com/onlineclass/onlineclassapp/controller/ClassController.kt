package com.onlineclass.onlineclassapp.controller

import com.onlineclass.onlineclassapp.model.Class
import com.onlineclass.onlineclassapp.service.ClassService
import com.onlineclass.onlineclassapp.service.UserToClassService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("classes")
class ClassController(
    private val classService: ClassService,
    private val userToClassService: UserToClassService
) {
    @GetMapping("{id}")
    fun getClassesByUserId(@PathVariable id: Long) = userToClassService.getActiveClassesByUserId(id)

    @PostMapping("create")
    fun createClass(@RequestBody clazz: Class): Class {
        val uuid = UUID.randomUUID().toString()
        val classCode = uuid.substring(0, uuid.indexOf("-"))
        return classService.createClass(
            Class(
                name = clazz.name,
                code = classCode
            )
        )
    }

    @PostMapping("archive/{id}")
    fun archiveClass(@PathVariable id: Long): Class = classService.archiveClass(id)

    @PostMapping("restore/{id}")
    fun restoreClass(@PathVariable id: Long): Class = classService.restoreClass(id)

    @PutMapping("{id}")
    fun updateClass(@PathVariable id: Long, @RequestBody clazz: Class): Class {
        return classService.updateClass(
            Class(
                id = id,
                name = clazz.name,
                code = clazz.code
            )
        )
    }
}