package cn.ksdshpx.javase.enhance;

import java.lang.reflect.Array;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/16
 * Time: 14:34
 * Description:数组的反射应用
 */
public class ArrayReflectionTest {
    public static void main(String[] args) {
        String[] arr1 = new String[]{"aa", "bb", "cc"};
        printObject(arr1);
        printObject("xyz");
    }

    private static void printObject(Object obj) {
        Class clazz = obj.getClass();
        if (clazz.isArray()) {
            int len = Array.getLength(obj);
            for (int i = 0; i < len; i++) {
                System.out.println(Array.get(obj, i));
            }
        } else {
            System.out.println(obj);
        }
    }
}
