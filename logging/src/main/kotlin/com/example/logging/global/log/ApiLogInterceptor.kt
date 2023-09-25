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
            request as ContentCachingRequestWrapper
            logger.info { "[Interceptor PRE Handler Request] ${handler.beanType.simpleName}.${handler.method.name} : ${request.method} ${request.requestURI} [Body] : ${String(request.contentAsByteArray)}" }
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
            request as ContentCachingRequestWrapper
            response as ContentCachingResponseWrapper
            logger.info { "[Interceptor Request] ${handler.beanType.simpleName}.${handler.method.name} : ${request.method} ${request.requestURI} [Body] : ${String(request.contentAsByteArray)}" }
            logger.info { "[Interceptor Response] ${handler.beanType.simpleName}.${handler.method.name} : ${response.status} [Body] : ${String(response.contentAsByteArray)}" }
        }
    }
}
