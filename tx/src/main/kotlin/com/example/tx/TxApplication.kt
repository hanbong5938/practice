package com.example.tx

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TxApplication

fun main(args: Array<String>) {
    runApplication<TxApplication>(*args)
}
