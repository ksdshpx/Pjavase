package cn.ksdshpx.javase.encrypt;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/16
 * Time: 21:57
 * Description:获取字符以及字符串的Ascii编码
 */
public class AsciiDemo {
    public static void main(String[] args) {
        //获取字符的Ascii编码
        char ch = 'A';
        int ascii = ch;
        System.out.println(ascii);
        //获取字符串的Ascii编码
        String str = "Hello";
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            int value = aChar;
            System.out.println(value);
        }
    }
}
