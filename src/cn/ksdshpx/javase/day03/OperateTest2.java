package cn.ksdshpx.javase.day03;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/1/19
 * Time: 14:14
 * Description:对两个整数进行互换（不能使用第三方变量）
 */
public class OperateTest2 {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        System.out.println("a=" + a + ",b=" + b);
        //法一,存在超出整数范围缺点
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a=" + a + ",b=" + b);
        //法二
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=" + a + ",b=" + b);
    }
}
