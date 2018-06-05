package cn.ksdshpx.javase.day1314;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/20
 * Time: 12:54
 * Description:死锁的示例--主要原因是同步的嵌套！
 */
class Res implements Runnable{
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private boolean flag = true;
    @Override
    public void run() {
        while (true){
            if(flag){
                synchronized (MyLock.myLocka){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"..if..myLocka");
                    synchronized (MyLock.myLockb){
                        System.out.println(Thread.currentThread().getName()+"..if..myLockb");
                    }
                }
            }
            else{
                synchronized (MyLock.myLockb){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"..else..myLockb");
                    synchronized (MyLock.myLocka){
                        System.out.println(Thread.currentThread().getName()+"..else..myLocka");
                    }
                }
            }
        }
    }
}

class MyLock{
    public static final MyLock myLocka = new MyLock();
    public static final MyLock myLockb = new MyLock();
}

public class DeadLockDemo {
    public static void main(String[] args) {
        Res res = new Res();
        Thread t1 = new Thread(res);
        Thread t2 = new Thread(res);
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        res.setFlag(false);
        t2.start();
    }
}
