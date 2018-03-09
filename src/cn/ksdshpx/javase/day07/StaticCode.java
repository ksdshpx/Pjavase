package cn.ksdshpx.javase.day07;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/3/9
 * Time: 16:10
 * Description:静态代码块
 * 特点：随着类的加载而执行且只执行一次！
 */
public class StaticCode {
    static {
        System.out.println("static code");
    }

    public void show() {
        System.out.println("show()..");
    }

    public static void main(String[] args) {
        new StaticCode().show();
        new StaticCode().show();
    }
}
