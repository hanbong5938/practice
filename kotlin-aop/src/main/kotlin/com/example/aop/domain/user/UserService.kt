package com.example.aop.domain.user

interface UserService {
    fun signUp(name: String): User?
    fun findAll(): MutableList<User>?
}
