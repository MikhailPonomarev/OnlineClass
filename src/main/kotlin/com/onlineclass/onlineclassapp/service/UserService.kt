package com.onlineclass.onlineclassapp.service

import com.onlineclass.onlineclassapp.model.User
import com.onlineclass.onlineclassapp.repository.UserRepository
import com.onlineclass.onlineclassapp.service.enums.UserRole
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository, private val roleService: RoleService) {
    fun getAll(): Iterable<User> = userRepository.findAll()

    fun getById(id: Long): User = userRepository.findById(id).orElse(null)

    fun createCuratorUser(user: User): User {
        user.roleId = roleService.getIdByDescription(UserRole.CURATOR.toString())
        return userRepository.save(user)
    }

    fun createStudentUser(user: User): User {
        user.roleId = roleService.getIdByDescription(UserRole.STUDENT.toString())
        return userRepository.save(user)
    }

    fun updateUser(user: User): User = userRepository.save(user)

    fun deleteUserById(id: Long) = userRepository.deleteById(id)
}