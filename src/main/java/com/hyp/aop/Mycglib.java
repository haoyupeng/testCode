package com.hyp.aop;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Mycglib implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(Thread.currentThread().getName()+"方法執行之前"+methodProxy.getSuperName());
        Object obj = methodProxy.invokeSuper(o, objects);
        System.out.println(Thread.currentThread().getName()+"方法執行之后"+method.getName());
        return obj;
    }
}
