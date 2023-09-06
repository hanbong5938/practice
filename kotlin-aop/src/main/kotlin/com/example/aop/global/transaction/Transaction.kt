package com.example.aop.global.transaction

import org.springframework.stereotype.Component

@Component
class Transaction(
    advice: TransactionAdvice,
) {

    init {
        transactionAdvice = advice
    }

    companion object {
        private lateinit var transactionAdvice: TransactionAdvice

        fun <T> writable(function: () -> T): T {
            return transactionAdvice.writable(function)
        }

        fun <T> readable(function: () -> T): T {
            return transactionAdvice.readable(function)
        }


    }


}
