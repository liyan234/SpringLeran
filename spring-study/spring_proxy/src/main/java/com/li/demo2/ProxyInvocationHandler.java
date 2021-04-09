package com.li.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    //生成代理类
    /**  Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
     new Class<?>[] { Foo.class },
     handler); */
    /** public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)*/
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    // 被处理的代理实例 并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**public Object invoke(Object obj, Object... args)
         * 动态代理的本质，就是使用反射机制实现的*/
        System.out.println("xxx");
        System.out.println(method.getName());
        Object ret = method.invoke(target, args);
        System.out.println("yyy");
        return ret;
    }
}
