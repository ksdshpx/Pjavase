package cn.ksdshpx.javase.day02;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/1/13
 * Time: 22:43
 * Description:变量的基本数据类型演示
 */
public class VarDemo {
    public static void main(String[] args) {
        /*
         * 一、变量的基本数据类型：三类8种
         *                  ---数值型
         *                       整数型（默认为int）
         *                            --byte   8位   -128~127
         *                            --short  16位  -32768~32767
         *                            --int    32位  -21亿~21亿
         *                            --long   64位
         *                       浮点型（默认为double）
         *                            --float  32位
         *                            --double 64位
         *                  ---字符型
         *                       --char 16位 0~65535
         *                  ---布尔型（默认为false）
         *                       --boolean true或false
         *
         * 二、变量的作用域：变量在定义它的代码块中生效
         */
        byte b = 8;
        short s = 123;
        int i = 12343;
        long l = 2142342L;
        float f = 12.34f;
        double d = 2.34;
        char ch = '1';
        boolean flag = true;
        System.out.println(flag);
    }
}
