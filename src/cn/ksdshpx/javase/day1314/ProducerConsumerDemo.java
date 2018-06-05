package cn.ksdshpx.javase.day1314;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/22
 * Time: 10:41
 * Description:多生产者多消费者问题
 */
//资源类
class ResDuck {
    private String name;
    private int count = 1;
    private boolean flag;//是否已经有资源

    /**
     * 生产方法
     *
     * @param name
     */
    public synchronized void set(String name) {
        while (this.flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + this.count;
        this.count++;
        System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
        this.flag = true;
        this.notifyAll();
    }

    /**
     * 消费方法
     */
    public synchronized void out() {
        while (!this.flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "...消费者........" + this.name);
        this.flag = false;
        this.notifyAll();
    }
}

//生产者
class Producer implements Runnable {
    private ResDuck res;

    public Producer(ResDuck res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            res.set("烤鸭");
        }
    }
}

//生产者
class Consumer implements Runnable {
    private ResDuck res;

    public Consumer(ResDuck res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            res.out();
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        ResDuck res = new ResDuck();
        Consumer cus1 = new Consumer(res);
        Consumer cus2 = new Consumer(res);
        Producer pro1 = new Producer(res);
        Producer pro2 = new Producer(res);
        Thread t0 = new Thread(cus1);
        Thread t1 = new Thread(cus2);
        Thread t2 = new Thread(pro1);
        Thread t3 = new Thread(pro2);
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
