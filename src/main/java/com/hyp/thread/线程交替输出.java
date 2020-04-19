package com.hyp.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 线程交替输出 {
    //    static Semaphore sp = new Semaphore(1);
    static ReentrantLock lock = new ReentrantLock();
    static Condition letter = lock.newCondition();
    static Condition digital = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            for (char i = 'A'; i <= 'Z'; i++) {
                System.out.println(i);
                if (i == 'Z')
                    i = 'A' - 1;
                digital.signal();
                try {
                    letter.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }).start();

        new Thread(() -> {
            lock.lock();
            for (char i = '0'; i <= '9'; i++) {
                System.out.println(i);
                if (i == '9')
                    i = '0' - 1;
                letter.signal();
                try {
                    digital.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }).start();


    }
}
