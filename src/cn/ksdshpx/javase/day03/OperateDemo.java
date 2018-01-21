package cn.ksdshpx.javase.day03;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/1/21
 * Time: 13:30
 * Description:三元运算符的演示
 */
public class OperateDemo {
    public static void main(String[] args) {
        int x = 3, y;
        y = (x > 1) ? x : 100;
        System.out.println(y);

        //需求：获取两个数的较大值
        int a = 100;
        int b = 101;
        int max = (a > b) ? a : b;
        System.out.println(max);
    }
}
