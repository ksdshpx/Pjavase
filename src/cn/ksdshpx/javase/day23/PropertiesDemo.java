package cn.ksdshpx.javase.day23;

import java.util.Properties;
import java.util.Set;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/12/22
 * Time: 10:44
 * Description:Properties集合的常见方法
 */
public class PropertiesDemo {
    public static void main(String[] args) {
        // 存、取、遍历方法
        //demo_1();
        // list方法（调试程序用）
        demo_2();
    }

    private static void demo_2() {
        Properties props = System.getProperties();
        props.list(System.out);
    }

    private static void demo_1() {
        //创建一个Properties集合
        Properties props = new Properties();
        //往集合中存入元素（注意Properties中键值都只能是String）
        props.setProperty("zhangSan", "20");
        props.setProperty("liSi", "25");
        props.setProperty("wangWu", "18");
        props.setProperty("zhaoLiu", "35");
        //遍历集合
        Set<String> names = props.stringPropertyNames();
        for (String name : names) {
            String value = props.getProperty(name);
            System.out.println(name + ":" + value);
        }
    }
}
