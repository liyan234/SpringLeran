package com.li.Demo1.diy;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/** 使用注解的方式 */
@Aspect // 标注这个类是一个切面
public class AnnotationPointCut {
    @Before("execution(* com.li.Demo1.UserServiceImp.*(..))")
    public void before() {
        System.out.println("====AnnotationBefore===");
    }

    @After("execution(* com.li.Demo1.UserServiceImp.*(..))")
    public void after() {
        System.out.println("====AnnAfter====");
    }

    //在环绕增强中，我们可以定于一个参数，代表我们要获取处理切入的点
    @Around("execution(* com.li.Demo1.UserServiceImp.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("====AnnAround前===");
        Object pr = jp.proceed();
        System.out.println("====AnnAround后===");
    }


}
