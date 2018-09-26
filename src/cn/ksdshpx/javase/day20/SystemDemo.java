package cn.ksdshpx.javase.day20;

import java.util.Properties;
import java.util.Set;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/26
 * Time: 14:15
 * Description:System类常用方法
 */
public class SystemDemo {
    public static void main(String[] args) {
        //1.获取当前时间的毫秒值(应用:测试程序运行时间)
        long startTime = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < 1000000000; i++) {
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("运行了：" + (endTime - startTime) + "毫秒！");
        //2.获取系统属性，并放到Properties对象中
        Properties props = System.getProperties();
        Set<String> nameSet = props.stringPropertyNames();
        for (String name : nameSet) {
            String value = props.getProperty(name);
            System.out.println(name + "=" + value);
        }
    }
}
