package cn.ksdshpx.javase.day10;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/4/17
 * Time: 21:53
 * Description:匿名内部类
 * 前提：内部类必须继承一个外类或实现一个接口
 */
abstract class Demo {
    abstract void show();
}

class Outer2 {
    int num = 4;

    void method() {
        //匿名内部类
        new Demo() {
            void show() {
                System.out.println("show..." + num);
            }
        }.show();
    }
}

public class InnerClassDemo2 {
    public static void main(String[] args) {
        new Outer2().method();
    }
}
