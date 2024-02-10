package com.onlineclass.onlineclassapp.model

import jakarta.persistence.*

@Entity
@Table(name = "user_to_class")
data class UserToClass(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @JoinColumn(name = "user_id")
    var userId: Long? = null,

    @JoinColumn(name = "class_id")
    var classId: Long? = null,

    @JoinColumn(name = "role_id")
    var roleId: Int? = null,

    @Column(name = "is_active")
    var isActive: Boolean? = true
)
