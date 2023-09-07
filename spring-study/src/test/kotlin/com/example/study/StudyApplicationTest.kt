package com.example.study

import com.example.study.service.TempService
import com.example.study.support.TestSupport
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class StudyApplicationTest: TestSupport() {

    @Autowired
    lateinit var temp: TempService

    @Autowired
    lateinit var temp2: TempService


    @Test
    fun test() {
        println("temp: $temp")
        println("temp2: $temp2")
    }
}
