package com.example.logging.domain.user

import org.springframework.stereotype.Service


@Service
class UserServiceImpl(
    val userRepository: UserRepository
) : UserService {


    override fun signUp(request: SignUpRequest): User {
        return userRepository.save(User(name = request.name))
    }

    override fun findAll(): MutableList<User> {
        return userRepository.findAll()
    }
}
