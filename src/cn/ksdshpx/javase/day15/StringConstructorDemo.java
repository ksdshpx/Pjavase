package cn.ksdshpx.javase.day15;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/6
 * Time: 22:43
 * Description:String构造函数
 */
public class StringConstructorDemo {
    public static void main(String[] args) {
        byte[] bytes = {65, 66, 67, 68};
        String s1 = new String(bytes);
        System.out.println("s1=" + s1);
        char[] chs = {'w', 'a', 'a', 'n'};
        String s2 = new String(chs);
        System.out.println("s2=" + s2);
        String s3 = new String(chs, 1, 2);
        System.out.println("s3=" + s3);
    }
}
