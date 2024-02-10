package com.onlineclass.onlineclassapp.controller

import com.onlineclass.onlineclassapp.model.User
import com.onlineclass.onlineclassapp.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users")
class UserController(private val userService: UserService) {
    @GetMapping
    fun getAllUsers() = userService.getAll()

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun getUserById(@PathVariable id: Long): User = userService.getById(id)

    @PostMapping("register/curator")
    fun registerCuratorUser(@RequestBody user: User): User = userService.createCuratorUser(user)

    @PostMapping("register/student")
    fun registerStudentUser(@RequestBody user: User): User = userService.createStudentUser(user)

    @PutMapping("{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: User): User {
        user.id = id
        return userService.updateUser(id, user)
    }

    @DeleteMapping("{id}")
    fun deleteUser(@PathVariable id: Long) = userService.deleteUserById(id)
}