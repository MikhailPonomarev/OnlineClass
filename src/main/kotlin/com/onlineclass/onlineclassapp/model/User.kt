package com.onlineclass.onlineclassapp.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "id")
    var id: Long? = null,

    @JsonProperty("lastName")
    @Column(name = "last_name")
    val lastName: String = "",

    @JsonProperty("firstName")
    @Column(name = "first_name")
    val firstName: String = "",

    @JsonProperty("middleName")
    @Column(name = "middle_name")
    val middleName: String? = null,

    @JsonProperty("email")
    @Column(name = "email")
    val email: String = "",

    @JsonProperty("roleId")
    @JoinColumn(name = "role_id")
    var roleId: Int? = null
)
