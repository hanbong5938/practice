package com.example.aop.domain.user

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    lateinit var userService: UserService

    @Test
    fun signUp() {
        val name = "test"
        val user = userService.signUp(name)

        assert(user?.name == name)
    }

    @Test
    fun findAll() {
        val name = "test"
        userService.signUp(name)
        val users = userService.findAll()!!

        var user = users.stream().filter { u -> u.name == name }.findFirst().orElse(null)

        assert(users.size > 0)
        assert(user?.name == name)
    }
}
