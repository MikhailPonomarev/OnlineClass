package com.onlineclass.onlineclassapp.model

import jakarta.persistence.*

@Entity
@Table(name = "classes")
data class Class(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "name")
    val name: String = "",

    @Column(name = "is_active")
    var isActive: Boolean? = true,

    @Column(name = "code")
    val code: String = ""
)