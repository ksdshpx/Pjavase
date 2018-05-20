package cn.ksdshpx.javase.day13;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/20
 * Time: 11:55
 * Description:多线程环境下单例中懒汉式的解决方式（同步+双重判断）
 * 同步是为了解决多线程的安全问题，双重判断是为了减少大量的锁判断消耗的资源
 */
class Single {
    private Single() {
    }

    private static Single instance = null;

    public static Single getInstance() {
        if (instance == null) {
            synchronized (Single.class) {
                if (instance == null) {
                    instance = new Single();
                }
            }
        }
        return instance;
    }
}

public class SingleDemo {
    public static void main(String[] args) {
        Single s1 = Single.getInstance();
        Single s2 = Single.getInstance();
        System.out.println(s1 == s2);//true
    }
}
