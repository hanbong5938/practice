package com.example.study.service

import org.springframework.stereotype.Service

@Service
class TempServiceImpl : TempService {
    override fun test() {
        println("TempService test")
    }
}
