package com.example.aop.domain.user

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun save() {
        // given && when
        val user = userRepository.save(User(name = "test"))

        // then
        val findUser = userRepository.findById(user.id).get()
        assert(findUser.id == user.id)
    }

}
