package com.hyp.thread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public class 线程交替输出3 {
    //    static Semaphore sp = new Semaphore(1);
    static AtomicBoolean ab = new AtomicBoolean(false);

    static Thread t, t1;

    public static void main(String[] args) {
        t = new Thread(() -> {
            for (char i = '0'; i <= '9'; i++) {
                while (true) {
                    if (ab.get()) {
                        System.out.println(i);
                        if (i == '9')
                            i = '0' - 1;
                        ab.set(false);
                        break;
                    }
                }
            }
        });

        t1 = new Thread(() -> {
            for (char i = 'A'; i <= 'Z'; i++) {
                while (true) {
                    if (!ab.get()) {
                        System.out.println(i);
                        if (i == 'Z')
                            i = 'A' - 1;
                        ab.set(true);
                        break;
                    }
                }
            }
        });

        t.start();
        t1.start();
    }
}
