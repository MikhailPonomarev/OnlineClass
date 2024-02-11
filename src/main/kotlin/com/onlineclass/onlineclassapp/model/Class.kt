package com.onlineclass.onlineclassapp.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "classes")
data class Class(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "id")
    var id: Long? = null,

    @JsonProperty("name")
    @Column(name = "name")
    var name: String = "",


    @JsonProperty("isActive")
    @Column(name = "is_active")
    var isActive: Boolean? = true,

    @JsonProperty("code")
    @Column(name = "code")
    val code: String = ""
)