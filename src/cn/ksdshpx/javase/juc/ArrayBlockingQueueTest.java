package cn.ksdshpx.javase.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/24
 * Time: 11:18
 * Description:阻塞队列ArrayBlockingQueueTest
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        final BlockingQueue queue = new ArrayBlockingQueue(3);
        //两个线程往阻塞队列中放数据
        for (int i = 0; i < 3; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 1000));
                        System.out.println("线程" + Thread.currentThread().getName() + "准备往队列里放数据");
                        queue.put("abc");
                        System.out.println("线程" + Thread.currentThread().getName() + "队列里有" + queue.size() + "个数据");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        //主线程从阻塞队列中取数据
        try {
            Thread.sleep(100);
            System.out.println("线程" + Thread.currentThread().getName() + "准备从队列里取数据");
            queue.take();
            System.out.println("线程" + Thread.currentThread().getName() + "队列里有" + queue.size() + "个数据");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();
    }
}
