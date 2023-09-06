package com.example.aop.global.transaction

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Component
class TransactionAdvice {

    @Transactional
    fun <T> writable(function: () -> T): T {
        return function.run { this() }
    }

    @Transactional(readOnly = true)
    fun <T> readable(function: () -> T): T {
        return function.run { this() }
    }
}
