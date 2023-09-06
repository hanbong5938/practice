package com.example.aop.domain.user

import com.example.aop.domain.common.BaseEntity
import jakarta.persistence.Entity

@Entity(name = "user_table")
data class User(var name: String) : BaseEntity() {
    constructor() : this("")
}
