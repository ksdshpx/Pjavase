package cn.ksdshpx.javase.enhance;

import java.lang.reflect.Method;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/9
 * Time: 15:26
 * Description:对接收数组参数的成员方法(其他类的main方法)进行反射
 */
public class ReflectionTest2 {
    public static void main(String[] args) {
        String className = args[0];
        try {
            Method mainMethod = Class.forName(className).getMethod("main", String[].class);
            mainMethod.invoke(null, new Object[]{new String[]{"111", "222", "333"}});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
