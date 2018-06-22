package cn.ksdshpx.javase.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/22
 * Time: 10:11
 * Description:CountDownLatch类
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        final CountDownLatch cdOrder = new CountDownLatch(1);
        final CountDownLatch cdAnswer = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程"+Thread.currentThread().getName()+"正在等待命令！");
                        cdOrder.await();
                        System.out.println("线程"+Thread.currentThread().getName()+"接收到命令！");
                        Thread.sleep((long) (Math.random()*1000));
                        cdAnswer.countDown();
                        System.out.println("线程"+Thread.currentThread().getName()+"回应命令处理结果！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        try {
            Thread.sleep((long) (Math.random()*1000));
            System.out.println("线程"+Thread.currentThread().getName()+"即将发布命令");
            System.out.println("线程"+Thread.currentThread().getName()+"发布命令");
            cdOrder.countDown();
            System.out.println("线程"+Thread.currentThread().getName()+"等待命令处理完成");
            cdAnswer.await();
            System.out.println("线程"+Thread.currentThread().getName()+"收到命令处理结果");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
