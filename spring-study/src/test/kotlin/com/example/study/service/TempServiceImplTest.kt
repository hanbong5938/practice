package com.example.study.service

import com.example.study.support.TestSupport
import org.junit.jupiter.api.Test


class TempServiceImplTest: TestSupport() {

    lateinit var tempService: TempService

    @Test
    fun test() {
        tempService.test()
    }
}
