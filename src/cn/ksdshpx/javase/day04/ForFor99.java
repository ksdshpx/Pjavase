package cn.ksdshpx.javase.day04;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/2/4
 * Time: 21:59
 * Description:打印九九乘法表
 */
public class ForFor99 {
    public static void main(String[] args) {
        /*
         *需求：打印九九乘法表
         *      1*1=1
         *      1*2=2 2*2=4
         *      1*3=3 2*3=6 3*3=9
         *      ...
         *      1*9=9 2*9=18 ......9*9=81
         */
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i + "\t");
            }
            System.out.println();
        }
    }
}
