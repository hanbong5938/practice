package com.example.tx.domain

import org.springframework.data.jpa.repository.JpaRepository

interface FooRepository: JpaRepository<Foo, Long> {
}
