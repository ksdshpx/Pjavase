package cn.ksdshpx.javase.juc;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/20
 * Time: 9:50
 * Description:CyclicBarrier类测试
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("线程" + Thread.currentThread().getName() + "即将到达目的地1" + ",还有" + (2-cyclicBarrier.getNumberWaiting()) + "个同学未到达目的地1");
                        cyclicBarrier.await();
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("线程" + Thread.currentThread().getName() + "目的地1已到达,即将去目的地2" + ",还有" + (2-cyclicBarrier.getNumberWaiting()) + "个同学未到达目的地2");
                        cyclicBarrier.await();
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("线程" + Thread.currentThread().getName() + "目的地2已到达,即将去目的地3" + ",还有" + (2-cyclicBarrier.getNumberWaiting()) + "个同学未到达目的地3");
                        cyclicBarrier.await();
                        System.out.println("都已到达目的地3,开始游玩！");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
