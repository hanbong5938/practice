package com.example.logging.domain.user

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class UserApi(private val userService: UserService) {

    @GetMapping("/all")
    fun findAll(): ResponseEntity<List<User>> = ResponseEntity.ok(userService.findAll())

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(@RequestBody request: SignUpRequest) = userService.signUp(request)
}
