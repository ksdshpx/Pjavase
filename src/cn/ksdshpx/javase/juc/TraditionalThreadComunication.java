package cn.ksdshpx.javase.juc;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/30
 * Time: 23:15
 * Description:传统线程间通讯
 */
class Business {
    private boolean flag;

    public synchronized void sub(int i) {
        while (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 10; j++) {
            System.out.println("sub thread sequece of " + j + ",loop of " + i);
        }
        this.flag = false;
        this.notifyAll();
    }

    public synchronized void main(int i) {
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 100; j++) {
            System.out.println("main thread sequece of " + j + ",loop of " + i);
        }
        this.flag = true;
        this.notifyAll();
    }
}

public class TraditionalThreadComunication {
    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    business.sub(i);
                }
            }
        }).start();

        for (int i = 1; i <= 50; i++) {
            business.main(i);
        }
    }
}
