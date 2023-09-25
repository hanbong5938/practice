package com.example.logging.global.log

import io.github.oshai.kotlinlogging.KotlinLogging
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestBody

@Aspect
@Component
class ApiLogAop {
    private val logger = KotlinLogging.logger {}

    @Pointcut(
        "@annotation(org.springframework.web.bind.annotation.GetMapping) ||"
                + "@annotation(org.springframework.web.bind.annotation.PostMapping) ||"
                + "@annotation(org.springframework.web.bind.annotation.PutMapping) ||"
                + "@annotation(org.springframework.web.bind.annotation.DeleteMapping)"
    )
    fun getPointCut() {
    }

    @Around(value = "getPointCut()")
    fun getAround(proceedingJoinPoint: ProceedingJoinPoint): Any {
        return info(proceedingJoinPoint)
    }

    private fun info(proceedingJoinPoint: ProceedingJoinPoint):Any {
        val signature = proceedingJoinPoint.signature as MethodSignature
        val body = getBody(proceedingJoinPoint, signature)
        val response = proceedingJoinPoint.proceed() as? ResponseEntity<*> ?: ResponseEntity.ok("")

        logger.info { "[ASPECTJ AOP Request] ${signature.declaringTypeName} ${signature.name} body : $body" }
        logger.info { "[ASPECTJ AOP Response] ${signature.declaringTypeName} ${signature.name} body : ${response.body}" }
        return response
    }


    private fun getBody(
        proceedingJoinPoint: ProceedingJoinPoint,
        methodSignature: MethodSignature
    ): Any? {
        val annotationMatrix = methodSignature.method.parameterAnnotations
        var index = -1
        for (annotations in annotationMatrix) {
            index++
            for (annotation in annotations) {
                if (annotation is RequestBody) {
                    return proceedingJoinPoint.args[index]
                }
            }
        }
        return null
    }

}
