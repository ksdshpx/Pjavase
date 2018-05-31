package cn.ksdshpx.javase.juc;

import java.util.Random;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/31
 * Time: 14:01
 * Description:ThreadLocal类的使用
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    static class A {
        public void get(int data) {
            System.out.println("A from " + Thread.currentThread().getName() + " get data:" + data);
        }
    }

    static class B {
        public void get(int data) {
            System.out.println("B from " + Thread.currentThread().getName() + " get data:" + data);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " put data:" + data);
                    threadLocal.set(data);
                    new A().get(threadLocal.get());
                    new B().get(threadLocal.get());
                }
            }
            ).start();
        }
    }
}
