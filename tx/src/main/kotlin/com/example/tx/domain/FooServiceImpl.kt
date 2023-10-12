package com.example.tx.domain

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FooServiceImpl(
    val fooRepository: FooRepository
) : FooService {
    @Transactional
    override fun saveFoo() {
        fooRepository.save(Foo(null, "bar"))
    }
}
