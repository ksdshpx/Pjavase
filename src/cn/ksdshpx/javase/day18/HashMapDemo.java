package cn.ksdshpx.javase.day18;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/14
 * Time: 15:27
 * Description:HashMap存储自定义对象
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<Student, String> map = new HashMap();
        map.put(new Student("zhangsan", 28), "北京");
        map.put(new Student("lisi", 30), "上海");
        map.put(new Student("wangwu", 28), "苏州");
        map.put(new Student("zhaoliu", 28), "深圳");
        map.put(new Student("zhangsan", 28), "济南");

        Set<Student> keySet = map.keySet();
        for (Iterator<Student> iterator = keySet.iterator(); iterator.hasNext(); ) {
            Student student = iterator.next();
            System.out.println(student.getName() + ":" + student.getAge() + "----" + map.get(student));
        }
    }
}
