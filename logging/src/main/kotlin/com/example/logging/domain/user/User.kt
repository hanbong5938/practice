package com.example.logging.domain.user

import com.example.logging.domain.common.BaseEntity
import jakarta.persistence.Entity

@Entity(name = "user_table")
data class User(var name: String) : BaseEntity() {
    constructor() : this("")
}
