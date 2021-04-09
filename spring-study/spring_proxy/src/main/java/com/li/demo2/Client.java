package com.li.demo2;

public class Client {
    public static void main(String[] args) {
        // 真实角色
        Host host = new Host();
        // 代理角色 现在没有
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        // 通过调用程序来处理我们要调用的接口对象
        handler.setTarget(host);

        // 生成代理角色
        Rent r = (Rent) handler.getProxy();
        r.rent();

    }
}
