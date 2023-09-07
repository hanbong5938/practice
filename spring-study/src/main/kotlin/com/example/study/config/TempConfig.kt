package com.example.study.config

import com.example.study.service.TempService
import com.example.study.service.TempServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class TempConfig {
    @Bean
    fun temp(): TempService {
        return TempServiceImpl()
    }

    @Bean
    fun temp2(): TempService {
        return TempServiceImpl()
    }
}
