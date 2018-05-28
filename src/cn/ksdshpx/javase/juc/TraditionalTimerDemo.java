package cn.ksdshpx.javase.juc;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/28
 * Time: 14:56
 * Description:传统定时器
 */
public class TraditionalTimerDemo {
    private static int count = 0;

    public static void main(String[] args) {
        /*new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bomb!!!");
            }
        }, 10000,3000);*/
        class MyTimerTask extends TimerTask {
            @Override
            public void run() {
                count = (count + 1) % 2;
                System.out.println("bomb!!!");
                new Timer().schedule(new MyTimerTask(), 2000 + 2000 * count);
            }
        }
        new Timer().schedule(new MyTimerTask(), 2000);
        while (true) {
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
