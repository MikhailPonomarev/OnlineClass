package com.onlineclass.onlineclassapp.service

import com.onlineclass.onlineclassapp.repository.RoleRepository
import org.springframework.stereotype.Service

@Service
class RoleService(private val roleRepository: RoleRepository) {
    fun getIdByDescription(description: String): Int =
        roleRepository.findAll().first { r -> r.description == description }.id!!
}