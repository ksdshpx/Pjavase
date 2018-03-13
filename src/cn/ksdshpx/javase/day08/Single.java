package cn.ksdshpx.javase.day08;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/3/13
 * Time: 22:21
 * Description:单例设计模式(饿汉式)
 *                单例设计模式作用：保证一个类在内存中只有一个实例。
 */
public class Single {
    //1.构造函数私有化
    private Single() {
    }

    //2.创建一个本类的实例
    private static Single instance = new Single();

    //3.对外提供一个方法，返回该类的实例
    public static Single getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Single instance1 = Single.getInstance();
        Single instance2 = Single.getInstance();
        System.out.println(instance1 == instance2);
    }
}
