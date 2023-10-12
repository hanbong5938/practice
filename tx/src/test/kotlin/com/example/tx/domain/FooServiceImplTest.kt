package com.example.tx.domain

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FooServiceImplTest {

    @Autowired
    lateinit var fooService: FooService

    @Test
    fun saveFoo() {
        fooService.saveFoo()


        print("Hello")
    }
}
