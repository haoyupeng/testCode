package com.hyp.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitNotify {
    static Object lock = new Object();
    static List<Object> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for(int i = 0; i<10 ;i++){
                System.out.println("add"+i);
                list.add(new Object());
                if(list.size() == 5){
                    synchronized (lock){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(()->{
            synchronized (lock){
                System.out.println("t2收到消息");
                lock.notify();
            }
        });

        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t2.start();
    }
}
