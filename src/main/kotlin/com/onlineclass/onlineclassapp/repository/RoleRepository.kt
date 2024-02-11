package com.onlineclass.onlineclassapp.repository

import com.onlineclass.onlineclassapp.model.Role
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : CrudRepository<Role, Int>