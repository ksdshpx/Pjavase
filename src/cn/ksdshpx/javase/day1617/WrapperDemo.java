package cn.ksdshpx.javase.day1617;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/4
 * Time: 19:48
 * Description:基本数据类型对象包装类
 */
public class WrapperDemo {
    public static void main(String[] args) {
        //基本数据类型与String的转换
        //1.String-->基本数据类型
        int i = Integer.parseInt("123");
        System.out.println(i + 3);
        //基本数据类型-->String
        String s = String.valueOf(123);
        System.out.println(s);
        //进制转换
        //十进制-->其他进制
        System.out.println(Integer.toBinaryString(60));
        System.out.println(Integer.toHexString(60));
        System.out.println(Integer.toOctalString(60));
        //其他进制-->十进制
        System.out.println(Integer.parseInt("3c",16));
    }
}
