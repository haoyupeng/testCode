package com.hyp.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AopFactory {
    public static <T> T wrap(Object o){
        ClassLoader cl = o.getClass().getClassLoader();
        Class<?>[] interfaces = o.getClass().getInterfaces();

        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("啪啪 前戏准备");
                Object result = method.invoke(o, args);
                System.out.println("啪啪 完事");
                return result;
            }
        };

        return (T)Proxy.newProxyInstance(cl,interfaces,h);
    }
}
