package com.example.logging.domain.user

interface UserService {
    fun signUp(request: SignUpRequest): User
    fun findAll(): MutableList<User>
}
