package cn.ksdshpx.javase.day03;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/2/2
 * Time: 10:18
 * Description:累加运算
 */
public class WhileTest {
    public static void main(String[] args) {
        /*
         *需求：计算1到100的和
         */
        int sum = 0;
        int x = 1;
        while (x <= 100) {
            sum += x;
            x++;
        }
        System.out.println("1到的100的和为：" + sum);
    }
}
