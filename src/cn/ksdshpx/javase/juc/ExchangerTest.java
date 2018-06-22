package cn.ksdshpx.javase.juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/22
 * Time: 10:37
 * Description:Exchanger类
 */
public class ExchangerTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        final Exchanger exchanger = new Exchanger();
        final String data1 = "黄金";
        final String data2 = "美元";
        for (int i = 0; i < 2; i++) {
            final int loopCount = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (loopCount == 0) {
                            System.out.println("线程" + Thread.currentThread().getName() + "准备交换:" + data1);
                            Thread.sleep((long) (Math.random() * 1000));
                            String returnData1 = (String) exchanger.exchange(data1);
                            System.out.println("线程" + Thread.currentThread().getName() + "交换回:" + returnData1);
                        } else {
                            System.out.println("线程" + Thread.currentThread().getName() + "准备交换:" + data2);
                            Thread.sleep((long) (Math.random() * 1000));
                            String returnData2 = (String) exchanger.exchange(data2);
                            System.out.println("线程" + Thread.currentThread().getName() + "交换回:" + returnData2);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
