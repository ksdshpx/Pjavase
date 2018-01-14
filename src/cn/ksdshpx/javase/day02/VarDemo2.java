package cn.ksdshpx.javase.day02;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/1/14
 * Time: 17:13
 * Description:自动类型转换、强制类型转换以及char类型计算
 */
public class VarDemo2 {
    public static void main(String[] args) {
        //自动类型转换
        int x = 5;
        byte b = 3;
        x = x + b;//b会自动类型提升为int型

        //强制类型转换（可能出现精度损失）
        byte c = 8;
        //c = c + 7;报错

        //byte、short、char类型进行数值运算时，会自动转化为int型
        char ch = 'a';
        System.out.println(ch);//a
        char cc = 'a' + 1;
        System.out.println(cc);//b
        System.out.println('a' + 1);//98
        //ch = ch + 1;报错
        ch = (char) (ch + 1);
        System.out.println(ch);//b
    }
}
