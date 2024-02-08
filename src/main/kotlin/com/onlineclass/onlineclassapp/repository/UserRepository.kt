package com.onlineclass.onlineclassapp.repository

import com.onlineclass.onlineclassapp.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long>