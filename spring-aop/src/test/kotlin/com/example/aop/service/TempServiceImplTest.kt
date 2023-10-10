package com.example.aop.service

import com.example.aop.support.TestSupport
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired


class TempServiceImplTest: TestSupport() {

    @Autowired
    lateinit var tempService: TempService

    @Test
    fun test() {
        tempService.test()
    }
}
