package com.hyp.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 线程交替输出1 {
    //    static Semaphore sp = new Semaphore(1);
    static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock) {
                for (char i = '0'; i <= '9'; i++) {
                    System.out.println(i);
                    if (i == '9')
                        i = '0' - 1;
                    try {
                        lock.notify();
                        lock.wait();
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();

        new Thread(() -> {
            synchronized (lock) {
                for (char i = 'A'; i <= 'Z'; i++) {
                    System.out.println(i);
                    if (i == 'Z')
                        i = 'A' - 1;
                    try {
                        lock.notify();
                        lock.wait();
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
