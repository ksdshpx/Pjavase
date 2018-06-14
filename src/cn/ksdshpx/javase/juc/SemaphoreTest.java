package cn.ksdshpx.javase.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/14
 * Time: 22:41
 * Description:Semaphore信号量机制
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取一盏信号灯
                        semaphore.acquire();
                        System.out.println("线程" + Thread.currentThread().getName() + "已进入,还能进入" + semaphore.availablePermits() + "个线程");
                        Thread.sleep(1000);
                        //释放信号灯
                        System.out.println("线程" + Thread.currentThread().getName() + "已离开");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
        }
    }
}
