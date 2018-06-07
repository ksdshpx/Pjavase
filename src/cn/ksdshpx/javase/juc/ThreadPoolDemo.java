package cn.ksdshpx.javase.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/7
 * Time: 10:43
 * Description:java5线程池
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //创建固定大小的线程池
        //ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //创建缓存线程池
        //ExecutorService threadPool = Executors.newCachedThreadPool();
        //创建单一线程池
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //创建
        int taskCount = 9;
        for (int i = 1; i <= taskCount; i++) {
            final int taskNum = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + " is looping of " + j + ",task of " + taskNum);
                    }
                }
            });
        }
        System.out.println("over!");
        //关闭线程池
        threadPool.shutdown();

        //创建定时调度的线程池
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("bomb!!!");
            }
        }, 6, 2, TimeUnit.SECONDS);
    }
}
