package cn.ksdshpx.javase.day13;

import java.util.concurrent.locks.*;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/23
 * Time: 10:57
 * Description:jdk1.5新特性--lock
 */
//资源
class Res4new {
    private String name;
    private int count = 1;
    private boolean flag;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void set(String name) {
        try{
            lock.lock();
            while (flag) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.name = name + count;
            count++;
            System.out.println(Thread.currentThread().getName() + "..生产者.." + this.name);
            this.flag = true;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void out() {
        try{
            lock.lock();
            while (!flag) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ".....消费者......" + this.name);
            this.flag = false;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}

//生产者
class Producer4new implements Runnable {
    private Res4new res;

    public Producer4new(Res4new res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            res.set("烤鸭");
        }
    }
}

//消费者
class Consumer4new implements Runnable {
    private Res4new res;

    public Consumer4new(Res4new res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true){
            res.out();
        }
    }
}

public class ProductConsumer4new {
    public static void main(String[] args) {
        Res4new res = new Res4new();
        Producer4new pro1 = new Producer4new(res);
        Producer4new pro2 = new Producer4new(res);
        Consumer4new con1 = new Consumer4new(res);
        Consumer4new con2 = new Consumer4new(res);
        Thread t0 = new Thread(pro1);
        Thread t1 = new Thread(pro2);
        Thread t2 = new Thread(con1);
        Thread t3 = new Thread(con2);
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
