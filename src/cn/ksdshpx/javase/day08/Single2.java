package cn.ksdshpx.javase.day08;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/3/13
 * Time: 22:46
 * Description:单例设计模式（懒汉式）
 *             懒汉式的特点在于实例的延迟加载，但存在多线程访问的问题。所以开发中用饿汉式。
 */
public class Single2 {
    private Single2() {
    }

    private static Single2 instance = null;

    public static Single2 getInstance() {
        if (instance == null) {
            instance = new Single2();
        }
        return instance;
    }
}
