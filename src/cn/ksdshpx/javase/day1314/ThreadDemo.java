package cn.ksdshpx.javase.day1314;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/16
 * Time: 10:34
 * Description:创建线程的第二种方式
 *              步骤：1，定义类，实现Runnable接口
 *                   2，覆盖Runnable接口的run()方法
 *                   3，创建Thread类，将Runnable接口的子类对象作为参数传递给其构造函数
 *                   4，调用Thread类的start()方法
 */
class Demo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+"---"+i);
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Demo d = new Demo();
        new Thread(d).start();
        new Thread(d).start();
    }
}
