package com.example.logging.domain.user

data class SignUpResponse(val name: String) {
    constructor(user: User) : this(user.name)
}
