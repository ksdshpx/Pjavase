package cn.ksdshpx.javase.encrypt;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/16
 * Time: 22:17
 * Description:凯撒加密解密
 */
public class KaiserDemo {
    public static void main(String[] args) {
        //demo01();
        String input = "Hello";
        int key = 1;
        String result = encrypt(input, key);
        System.out.println(result);
        System.out.println(decrypt(result, key));
    }

    /**
     * 凯撒加密
     *
     * @param input
     * @param key
     */
    private static String encrypt(String input, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char ch : chars) {
            int value = ch;
            value = value + key;
            char result = (char) value;
            stringBuilder.append(result);
        }
        return stringBuilder.toString();
    }

    /**
     * 凯撒解密
     *
     * @param input
     * @param key
     */
    private static String decrypt(String input, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char ch : chars) {
            int value = ch;
            value = value - key;
            char result = (char) value;
            stringBuilder.append(result);
        }
        return stringBuilder.toString();
    }


    /**
     * 单个字符的凯撒加密（其实就是字符偏移）
     */
    private static void demo01() {
        char ch = 'A';
        int value = ch;
        value = value + 2;
        char result = (char) value;
        System.out.println("result:" + result);
    }
}
