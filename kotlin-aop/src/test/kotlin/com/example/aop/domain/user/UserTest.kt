package com.example.aop.domain.user

import org.junit.jupiter.api.Test

class UserTest {

    @Test
    fun getName() {
        val user = User("test")

        assert(user.name == "test")
    }

    @Test
    fun setName() {
        val user = User("test")
        user.name = "test2"

        assert(user.name == "test2")
    }
}
