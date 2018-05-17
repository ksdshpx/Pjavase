package cn.ksdshpx.javase.day13;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/17
 * Time: 18:58
 * Description:多线程示例--卖票
 */
class Ticket implements Runnable/*extends Thread*/ {
    private int num = 100;

    @Override
    public void run() {
        while (true) {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "--sale--" + num--);
            }
        }
    }
}

public class TicketDemo {
    public static void main(String[] args) {
        /*Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        Ticket t3 = new Ticket();
        Ticket t4 = new Ticket();
        t1.start();
        t2.start();
        t3.start();
        t4.start();*/
        Ticket t = new Ticket();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
