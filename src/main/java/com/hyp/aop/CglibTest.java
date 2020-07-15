package com.hyp.aop;


import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.core.KeyFactory;
import net.sf.cglib.proxy.Enhancer;

import java.util.function.Supplier;

public class CglibTest {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "d:\\aopAutoCode");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Mycaculat.class);
        enhancer.setCallback(new Mycglib());

        Mycaculat m = (Mycaculat) enhancer.create();
        System.out.println(m.add(1,2));
//
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "d:\\aopAutoCode");
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(Caculate.class);
//        enhancer.setCallback(new Mycglib());
//
//        Caculate m = (Caculate) enhancer.create();
//        System.out.println(m.add(1,2));
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "d:\\aopAutoCode");
//        dddddd KEY_FACTORY =
//                (dddddd) KeyFactory.create(dddddd.class, KeyFactory.HASH_ASM_TYPE, null);
//        dddddd aa =  (dddddd)KEY_FACTORY.newInstance(1,3);
//        System.out.println(aa);
//        int ia = 0;
    }
}
