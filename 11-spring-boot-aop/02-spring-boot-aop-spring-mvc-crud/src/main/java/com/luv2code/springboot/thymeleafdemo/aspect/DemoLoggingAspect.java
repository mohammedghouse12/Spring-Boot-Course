package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.xml.crypto.dsig.SignatureMethod;
import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    public void forController(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    public void forDao(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    public void forService(){}

    @Pointcut("forController() || forDao() || forService()")
    public void forControllerDaoService(){}

    @Before("forControllerDaoService()")
    public void before(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        logger.info(method + " is being called");

        Object args[] = joinPoint.getArgs();

        for(Object arg: args){
            logger.info("Argument: "+arg);
        }
    }
    @AfterReturning(pointcut = "forControllerDaoService()", returning = "result")
    public void after(JoinPoint joinPoint, Object result){
        String method = joinPoint.getSignature().toShortString();
        logger.info(method + " is being called");
        logger.info("Result: "+ result);
    }
}
