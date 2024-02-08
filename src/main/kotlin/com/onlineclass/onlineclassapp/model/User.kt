package com.onlineclass.onlineclassapp.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "id") var id: Long? = null,

    @JsonProperty("last_name")
    @Column(name = "last_name")
    val lastName: String = "",

    @JsonProperty("first_name")
    @Column(name = "first_name")
    val firstName: String = "",

    @JsonProperty("middle_name")
    @Column(name = "middle_name")
    val middleName: String? = null,

    @JsonProperty("email")
    @Column(name = "email")
    val email: String = ""
)
