package com.onlineclass.onlineclassapp.repository

import com.onlineclass.onlineclassapp.model.Class
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClassRepository : CrudRepository<Class, Long>