package com.hyp.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

public class 人生如梦 {
    public static void main(String[] args) throws InterruptedException {
        MarriyPhaser mp = new MarriyPhaser();
        mp.bulkRegister(7);
        List<Thread> ddd = new ArrayList<>();
        for(int i = 0;i<5; i++){
            Thread tt = new Thread(new Person(mp,i+""));
            tt.start();
            ddd.add(tt);
        }
        Thread tt = new Thread(new Person(mp,"新郎"));
        tt.start();
        ddd.add(tt);
        Thread tt1 = new Thread(new Person(mp,"新娘"));
        tt1.start();
        ddd.add(tt1);

        for(Thread ttt:ddd){
            ttt.join();
        }
        System.out.println(Thread.currentThread().getName()+"这就是人生");
    }

    static class Person implements Runnable{
        MarriyPhaser mp;
        String name;

        Person(MarriyPhaser mp,String name){
            this.mp = mp;
            this.name = name;
        }

        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName()+"我到桌子了");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mp.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName()+"我吃上饭了");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mp.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName()+"我回家了");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mp.arriveAndAwaitAdvance();
            if(this.name.equals("新郎")||this.name.equals("新娘")){
                System.out.println(Thread.currentThread().getName()+this.name+"终于啪啪啪了");
                mp.arriveAndAwaitAdvance();
            }else{
                mp.arriveAndDeregister();
            }
        }
    }

    static class MarriyPhaser extends Phaser{
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase){
                case 0:
                    System.out.println(Thread.currentThread().getName()+"大伙都到了");
                    return false;
                case 1:
                    System.out.println(Thread.currentThread().getName()+"大伙都吃上了");
                    return false;
                case 2:
                    System.out.println(Thread.currentThread().getName()+"大伙都散了");
                    return false;
                case 3:
                    System.out.println(Thread.currentThread().getName()+"生了娃");
                    return false;
                default:
                    return true;
            }
        }
    }
}
