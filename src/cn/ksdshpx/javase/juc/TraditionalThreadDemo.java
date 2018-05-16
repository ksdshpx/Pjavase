package cn.ksdshpx.javase.juc;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/16
 * Time: 18:10
 * Description:传统线程技术回顾
 */
public class TraditionalThreadDemo {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                }
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                }
            }
        }).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
    }
}
