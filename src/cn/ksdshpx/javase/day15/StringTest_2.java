package cn.ksdshpx.javase.day15;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/26
 * Time: 9:59
 * Description:字符串练习
 * 需求：一个子串在整串中出现的次数
 */
public class StringTest_2 {
    public static void main(String[] args) {
        String str = "nbadsfernbajomnbafsereonbadronba";
        String key = "nba";
        int count = getKeyStrCount_1(str, key);
//        int count = getKeyStrCount_2(str, key);
        System.out.println("count:" + count);
    }

    public static int getKeyStrCount_2(String str, String key) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(key, index)) != -1) {
            count++;
            index = index + key.length();
        }
        return count;
    }

    public static int getKeyStrCount_1(String str, String key) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(key)) != -1) {
            count++;
            str = str.substring(index + key.length());
        }
        return count;
    }
}
