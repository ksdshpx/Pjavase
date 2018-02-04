package cn.ksdshpx.javase.day04;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/2/4
 * Time: 21:10
 * Description:打印*图形
 */
public class ForForTest2 {
    public static void main(String[] args) {
        /*
         *需求：打印
         *         *****
         *         ****
         *         ***
         *         **
         *         *
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        /*
         *需求：打印
         *         *
         *         **
         *         ***
         *         ****
         *         *****
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        /*
         *需求：打印
         *         54321
         *         5432
         *         543
         *         54
         *         5
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print(5 - j);
            }
            System.out.println();
        }


        /*
         *需求：打印
         *         *
         *         **
         *         ***
         *         ****
         *         *****
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(i + 1);
            }
            System.out.println();
        }
        /*
         *需求：打印
         *         * * * * *
         *          * * * *
         *           * * *
         *            * *
         *             *
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
