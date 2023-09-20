package com.example.logging

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinLogApplication

fun main(args: Array<String>) {
    runApplication<KotlinLogApplication>(*args)
}
