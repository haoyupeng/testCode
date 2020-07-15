package com.hyp.aop;

import java.lang.reflect.InvocationHandler;

public class AopTest {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Caculate c = AopFactory.wrap(new CaculateImpl());
        System.out.println(c.add(1,3));
        System.out.println(c.getClass());
    }
}
