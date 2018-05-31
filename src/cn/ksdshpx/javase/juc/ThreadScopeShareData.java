package cn.ksdshpx.javase.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/31
 * Time: 14:01
 * Description:线程范围内的共享变量
 */
public class ThreadScopeShareData {
    private static int data = 0;
    private static Map<Thread, Integer> threadMap = new HashMap<>();

    static class A {
        public void get(int data) {
            System.out.println("A from" + Thread.currentThread().getName() + " get data:" + data);
        }
    }

    static class B {
        public void get(int data) {
            System.out.println("B from" + Thread.currentThread().getName() + " get data:" + data);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (ThreadScopeShareData.class){
                        data = new Random().nextInt();
                        System.out.println(Thread.currentThread().getName() + " put data:" + data);
                        threadMap.put(Thread.currentThread(), data);
                        new A().get(threadMap.get(Thread.currentThread()));
                        new B().get(threadMap.get(Thread.currentThread()));
                    }
                }
            }
            ).start();
        }
    }
}
