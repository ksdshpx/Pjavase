package cn.ksdshpx.javase.day12;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/14
 * Time: 13:50
 * Description:多线程创建方式一
 *             步骤：1.定义类继承Thread
 *                  2.覆盖Thread类的run()方法
 *                  3.创建线程对象并调用其start()方法
 *
 *             **start()方法的作用：1.开启线程 2.调用run()方法
 */
class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread().getName() + "--name:" + name + i);
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("旺财");
        MyThread thread2 = new MyThread("小强");
        thread1.start();
        thread2.start();
    }
}
