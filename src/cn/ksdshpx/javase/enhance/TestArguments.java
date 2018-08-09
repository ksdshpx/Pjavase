package cn.ksdshpx.javase.enhance;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/9
 * Time: 15:20
 * Description:对接收数组参数的成员方法进行反射
 */
public class TestArguments {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
