package cn.ksdshpx.javase.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/29
 * Time: 17:44
 * Description:java5锁机制Lock
 */
public class LockDemo {
    static class Outputer{
        private Lock lock = new ReentrantLock();
        private void output(String name){
                try {
                    lock.lock();
                    for (int i = 0; i < name.length(); i++) {
                        System.out.print(name.charAt(i));
                    }
                    System.out.println();
                }finally {
                    lock.unlock();
                }
        }
    }
    public static void main(String[] args) {
        final Outputer outputer = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    outputer.output("hanshunping");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    outputer.output("tonggang");
                }
            }
        }).start();
    }
}
