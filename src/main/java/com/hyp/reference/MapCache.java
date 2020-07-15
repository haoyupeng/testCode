package com.hyp.reference;

import java.util.*;
import java.lang.ref.*;

class Key {
    String id;

    public Key(String id) {
        this.id = id;
    }
    public String toString() {
        return id;
    }
    public int hashCode() {
        return id.hashCode();
    }
    public boolean equals(Object r) {
        return (r instanceof Key) && id.equals(((Key) r).id);
    }
    public void finalize() {
        System.out.println("Finalizing Key " + id);
    }
}
class Value {
    String id;
    public Value(String id) {
        this.id = id;
    }
    public String toString() {
        return id;
    }
    public void finalize() {
        System.out.println("Finalizing Value " + id);
    }
}

public class MapCache {
    public static void main(String[] args) throws Exception {
        int size = 1000;// 或者从命令行获得size的大小
        if (args.length > 0)
            size = Integer.parseInt(args[0]);
        Key[] keys = new Key[size]; // 存放键对象的强引用
        WeakHashMap whm = new WeakHashMap();
        for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i % 3 == 0)
                keys[i] = k; // 使Key对象持有强引用
            whm.put(k, v); // 使Key对象持有弱引用
        }
        // 催促垃圾回收器工作
        System.gc();// 把CPU让给垃圾回收器线程
        Thread.sleep(8000);
        //虚引用是随机的回收，不是全部回收
        System.out.println("whm.size()"+whm.size());
    }
}