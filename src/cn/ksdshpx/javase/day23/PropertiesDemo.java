package cn.ksdshpx.javase.day23;

import java.io.*;
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
    public static void main(String[] args) throws IOException {
        // 存、取、遍历方法
        //demo_1();
        // list方法（调试程序用）
        //demo_2();
        // store方法
        //demo_3();
        // load方法
        //domo_4();
        //自定义load方法
        demo_5();
    }

    private static void demo_5() throws IOException {
        Properties props = new Properties();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\info.txt"));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.contains("=")) {
                continue;
            }
            String[] arr = line.split("=");
            props.setProperty(arr[0], arr[1]);
        }
        props.list(System.out);
        bufferedReader.close();
    }

    private static void domo_4() throws IOException {
        Properties props = new Properties();
        FileInputStream inputStream = new FileInputStream("D:\\info.txt");
        props.load(inputStream);
        props.list(System.out);
        inputStream.close();
    }

    private static void demo_3() throws IOException {
        //创建一个Properties集合
        Properties props = new Properties();
        //往集合中存入元素（注意Properties中键值都只能是String）
        props.setProperty("zhangSan", "20");
        props.setProperty("liSi", "25");
        props.setProperty("wangWu", "18");
        props.setProperty("zhaoLiu", "35");
        FileOutputStream outputStream = new FileOutputStream("D:\\info.txt");
        props.store(outputStream, "name+age");
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
