package com.onlineclass.onlineclassapp.service

import com.onlineclass.onlineclassapp.model.User
import com.onlineclass.onlineclassapp.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun getAll(): Iterable<User> = userRepository.findAll()

    fun getById(id: Long): User = userRepository.findById(id).orElse(null)

    fun createUser(user: User): User = userRepository.save(user)

    fun updateUser(id: Long, user: User): User = userRepository.save(user)

    fun deleteUserById(id: Long) = userRepository.deleteById(id)
}