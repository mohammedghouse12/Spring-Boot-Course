package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AopExpressions {
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDAOPackage(){}

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    private void getter(){};

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    private void setter(){};

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOPackageNoGetterSetter(){}

}
