package cn.ksdshpx.javase.juc;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/8
 * Time: 14:20
 * Description:多线程下Callable+Future+FutureTask机制
 */
public class CallableFutureDemo {
    @Test
    public void test() {
        //使用Callable+Future获取执行结果
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<Integer> future = threadPool.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                int sum = 0;
                System.out.println("计算线程开始啦！");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 5000; i++) {
                    sum = sum + i;
                }
                System.out.println("计算线程结束啦！");
                return sum;
            }
        });
        //关闭线程池
        threadPool.shutdown();
        try {
            Thread.sleep(2000);
            System.out.println("执行主线程的其他任务！");
            if (future.get() != null) {
                //输出获取到的结果
                System.out.println("future.get()-->" + future.get());
            } else {
                //输出获取到的结果
                System.out.println("future.get()未获取到结果");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕！");
    }

    @Test
    public void test2() {
        //使用Callable+FutureTask获取执行结果
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() {
                int sum = 0;
                System.out.println("计算线程开始啦！");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 5000; i++) {
                    sum = sum + i;
                }
                System.out.println("计算线程结束啦！");
                return sum;
            }
        });
        threadPool.submit(futureTask);
        //关闭线程池
        threadPool.shutdown();
        try {
            Thread.sleep(2000);
            System.out.println("执行主线程的其他任务！");
            if (futureTask.get() != null) {
                //输出获取到的结果
                System.out.println("future.get()-->" + futureTask.get());
            } else {
                //输出获取到的结果
                System.out.println("future.get()未获取到结果");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕！");
    }
}
