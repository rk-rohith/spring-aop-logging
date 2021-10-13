package com.spring.aop.logging.aop;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

    @Autowired
    ObjectMapper mapper;

    Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut(value = "execution(* com.spring.aop.logging.*.*.*(..))")
    public void myPointcut() {

    }

    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName(); // gives method name
        String className = proceedingJoinPoint.getTarget().getClass().toString(); // gives class name
        Object[] array = proceedingJoinPoint.getArgs();
        log.info("method invoked {}:{}() arguments: {}", className, methodName, mapper.writeValueAsString(array));
        Object object = proceedingJoinPoint.proceed();
        log.info("{}.{}() Response: {}", className, methodName, mapper.writeValueAsString(object));
        return object;
    }

}
