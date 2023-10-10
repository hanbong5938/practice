package com.example.aop.service

import org.springframework.stereotype.Service

@Service
class TempServiceImpl : TempService {
    override fun test() {
        println("TempService test")
    }
}
