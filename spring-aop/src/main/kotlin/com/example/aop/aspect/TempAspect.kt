package com.example.aop.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class TempAspect {
    @Around("execution(* com.example.aop.service.TempService.test())")
    fun logging(proceedingJoinPoint: ProceedingJoinPoint): Any? {
        println("시작")
        val result = proceedingJoinPoint.proceed()
        println("끝 $result")
        return result
    }
}
