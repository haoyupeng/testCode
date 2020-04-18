package com.hyp;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class TestLockSupport {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for(int i = 0;i<10; i++){
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i==5){
                    LockSupport.park();
                }
                if(i==8){
                    System.out.println("parkNanos(100000)");
                    LockSupport.parkNanos(10000);
                }
            }
            System.out.println("parkNanos 到头了");
        });
        t.start();
        LockSupport.unpark(t);
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main 到头了");
    }
}
