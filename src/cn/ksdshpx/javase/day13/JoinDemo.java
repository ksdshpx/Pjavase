package cn.ksdshpx.javase.day13;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/27
 * Time: 17:18
 * Description:线程的常用方法
 */
class RunDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName() + "..." + i);
        }
    }
}

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        RunDemo d = new RunDemo();
        Thread t1 = new Thread(d);
        Thread t2 = new Thread(d);
        t1.start();
        //t1.join();//等待t1线程先执行完，再执行其他的
        t2.start();
        t2.setPriority(Thread.MAX_PRIORITY);
        for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName() + "..." + i);
        }
    }
}
