package cn.ksdshpx.javase.day13;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/19
 * Time: 16:45
 * Description:银行存钱示例（同步函数的使用）
 */
class Bank {
    private int sum;

    /*
    同步代码块解决线程安全问题
    public void add(int num) {
        synchronized (Bank.class){
            sum = sum + num;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sum=" + sum);
        }
    }*/

    // 同步函数解决线程安全问题
    public void add(int num) {
        synchronized (Bank.class){
            sum = sum + num;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sum=" + sum);
        }
    }
}

class Cus implements Runnable{
    private Bank bank = new Bank();
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            bank.add(100);
        }
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Cus c1 = new Cus();
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c1);
        t1.start();
        t2.start();
    }
}
