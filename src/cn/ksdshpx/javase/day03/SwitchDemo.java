package cn.ksdshpx.javase.day03;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/1/29
 * Time: 21:30
 * Description:switch语句演示
 */
public class SwitchDemo {
    public static void main(String[] args) {
        int x = 3;
        switch (x) {
            case 1:
                System.out.println("a");
                break;
            case 2:
                System.out.println("b");
                break;
            case 3:
                System.out.println("c");
                break;
            default:
                System.out.println("d");
                break;
        }
    }
}
