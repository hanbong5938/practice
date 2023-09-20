package com.example.logging.global.log

import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper


class ApiLogInterceptor : HandlerInterceptor {
    private val logger = KotlinLogging.logger {}
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if (handler is HandlerMethod) {
            val wrapper = request as ContentCachingRequestWrapper
            val body = String(wrapper.contentAsByteArray)
            logger.info { "[Interceptor Request] ${handler.beanType.simpleName}.${handler.method.name} : ${request.method} ${request.requestURI} [Body] : $body" }
        }
        return true
    }

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        if (handler is HandlerMethod) {
            val wrapper = response as ContentCachingResponseWrapper
            val body = String(wrapper.contentAsByteArray)
            logger.info { "[Interceptor Response] ${handler.beanType.simpleName}.${handler.method.name} : ${response.status} [Body] : $body" }
        }
    }

}
