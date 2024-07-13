package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.Signature;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

//    @Before("execution(public void add*())")

//    @Before("execution(* add*())")

//    @Before("execution(* add*(com.luv2code.aopdemo.entity.*))")

//    @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")

//    @Before("com.luv2code.aopdemo.aspect.AopExpressions.forDAOPackageNoGetterSetter()")
//    public void beforeAddAccountAdvice(JoinPoint joinPoint){
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Object args[]= joinPoint.getArgs();
//
//        System.out.println(methodSignature);
//
//        for(Object arg: args){
//            System.out.println(arg);
//            if(arg instanceof Account){
//                Account account = (Account) arg;
//                System.out.println("Account name: "+account.getName());
//                System.out.println("Account level: "+account.getLevel());
//            }
//        }
//
//        System.out.println("In adding account");
//    }

//    @AfterReturning("com.luv2code.aopdemo.aspect.AopExpressions.forDAOPackageNoGetterSetter()")
//    public void happPath(){
//        System.out.println("Executed the method call successfully");
//    }
//
    @AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, List<Account> result){
        if(!result.isEmpty()){
            for(Account account: result)
            account.setName(account.getName().toUpperCase());
        }
    }

    @AfterThrowing(pointcut =  "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable exception){
        System.out.println(exception.getMessage());
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterBlock(JoinPoint joinPoint){
        System.out.println("Yohohoho");
    }

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("In around: "+method);
        long begin = System.currentTimeMillis();

        Object result = null;

        try{
            result = proceedingJoinPoint.proceed();

            long end = System.currentTimeMillis();

            long duration = end - begin;

            System.out.println("Duration of execution: "+duration/1000);

            return result;
        }
        catch(Throwable exception){
            System.out.println("We have an exception: "+exception);
            throw exception;
        }
    }
}
