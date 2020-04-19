package com.hyp.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 生产者消费者 {
    static ReentrantLock lock = new ReentrantLock();
    static Condition p = lock.newCondition();
    static Condition c = lock.newCondition();

    static List<Object> storage = new ArrayList<>();

    public static void main(String[] args) {
        new Thread(()->{
            while(true) {
                lock.lock();
                while (storage.size() == 10) {
                    try {
                        p.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                storage.add(new Object());
                System.out.println("生产了一个");
                c.signal();
                lock.unlock();
            }
        }).start();

        new Thread(()->{
            while(true) {
                lock.lock();
                while (storage.size() == 0) {
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                storage.add(new Object());
                System.out.println("消费了一个");
                p.signal();
                lock.unlock();
            }
        }).start();
        new Thread(()->{
            while(true) {
                lock.lock();
                while (storage.size() == 0) {
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                storage.add(new Object());
                System.out.println("消费了一个");
                p.signal();
                lock.unlock();
            }
        }).start();
    }
}
