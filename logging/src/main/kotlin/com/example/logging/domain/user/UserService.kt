package com.example.logging.domain.user

interface UserService {
    fun findAll(): MutableList<User>
    fun signUp(request: SignUpRequest)
}
