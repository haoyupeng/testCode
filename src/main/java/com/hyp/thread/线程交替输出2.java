package com.hyp.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class 线程交替输出2 {
    //    static Semaphore sp = new Semaphore(1);

    static Thread t,t1;
    public static void main(String[] args) {
        t = new Thread(() -> {
                for (char i = '0'; i <= '9'; i++) {
                    System.out.println(i);
                    if (i == '9')
                        i = '0' - 1;
                    LockSupport.unpark(t1);
                    LockSupport.park();
                }
        });

        t1 = new Thread(() -> {
                for (char i = 'A'; i <= 'Z'; i++) {
                    LockSupport.park();
                    System.out.println(i);
                    if (i == 'Z') {
                        i = 'A' - 1;
                    }
                    LockSupport.unpark(t);
                }
        });

        t.start();
        t1.start();
    }
}
