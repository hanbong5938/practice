package com.example.aop.domain.user

import com.example.aop.global.transaction.Transaction
import org.springframework.stereotype.Service


@Service
class UserServiceImpl(
    val userRepository: UserRepository
) : UserService {


    override fun signUp(name: String): User = Transaction.writable {
        userRepository.save(User(name = name))
    }

    override fun findAll(): MutableList<User> = Transaction.readable {
        userRepository.findAll()
    }
}
