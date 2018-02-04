package cn.ksdshpx.javase.day04;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/2/4
 * Time: 17:00
 * Description:打印*矩形示例
 */
public class ForForTest {
    public static void main(String[] args) {
        /*
         * 需求：打印
         *       *****
         *       *****
         *       *****
         *       *****
         */
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
