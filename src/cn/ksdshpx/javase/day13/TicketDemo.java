package cn.ksdshpx.javase.day13;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/17
 * Time: 18:58
 * Description:多线程示例--卖票
 *                  多线程安全问题产生的原因：
 *                          1，多个线程在操作共享的数据
 *                          2，操作共享数据的线程代码有多条
 *
 *                  同步的前提：必须有多个线程并使用同一个锁
 *
 *                  同步函数的锁是this,静态同步函数的锁是该函数所属的字节码文件对象（当前类名.class），同步代码块的锁是任意对象，建议使用同步代码块。
 */
class Ticket implements Runnable/*extends Thread*/ {
    private int num = 100;

    @Override
    public void run() {
        while (true) {
            synchronized(this){
                if (num > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "--sale--" + num--);
                }
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
