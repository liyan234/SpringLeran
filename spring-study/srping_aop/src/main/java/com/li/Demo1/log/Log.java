package com.li.Demo1.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Log implements MethodBeforeAdvice {


    // method 要执行目标对象的方法
    // args 参数
    // target 目标对象
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了" + method.getName() + "方法");
    }
}
