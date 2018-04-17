package cn.ksdshpx.javase.day10;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/4/17
 * Time: 22:09
 * Description:匿名内部类应用
 */
interface Inter {
    public abstract void show1();

    public abstract void show2();
}

class Outer3 {
    void method(){
        Inter in = new Inter(){

            @Override
            public void show1() {
                System.out.println("show1()..");
            }

            @Override
            public void show2() {
                System.out.println("show2()..");
            }
        };
        in.show1();
        in.show2();
    }
}

public class InnerClassDemo3 {
    public static void main(String[] args) {
        new Outer3().method();
    }
}
