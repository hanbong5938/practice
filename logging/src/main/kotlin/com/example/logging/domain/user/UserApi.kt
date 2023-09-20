package com.example.logging.domain.user

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
class UserApi(private val userService: UserService) {

    @GetMapping("/all")
    fun findAll(): List<User> {
        return userService.findAll()
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(@RequestBody request: SignUpRequest): SignUpResponse {
        val user = userService.signUp(request)
        return SignUpResponse(user)
    }
}
