package com.example.logging.global.log

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.core.MethodParameter
import org.springframework.http.HttpInputMessage
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter
import java.lang.reflect.Type

@RestControllerAdvice
class RequestBodyLoggingAdvice : RequestBodyAdviceAdapter() {
    private val logger = KotlinLogging.logger {}

    override fun supports(
        methodParameter: MethodParameter,
        targetType: Type,
        converterType: Class<out HttpMessageConverter<*>>
    ): Boolean {
        return true
    }

    override fun afterBodyRead(
        body: Any,
        inputMessage: HttpInputMessage,
        parameter: MethodParameter,
        targetType: Type,
        converterType: Class<out HttpMessageConverter<*>>
    ): Any {
        logger.info { "[ADVICE Request] ${parameter.method.name} body : $body" }
        return body
    }
}
