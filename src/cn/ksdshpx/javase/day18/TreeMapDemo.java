package cn.ksdshpx.javase.day18;

import java.util.*;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/14
 * Time: 15:39
 * Description:TreeMap集合
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        Map<Student, String> map = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int compareResult = o1.getName().compareTo(o2.getName());
                return compareResult == 0 ? o1.getAge() - o2.getAge() : compareResult;
            }
        });
        map.put(new Student("zhangsan", 28), "北京");
        map.put(new Student("lisi", 30), "上海");
        map.put(new Student("wangwu", 19), "苏州");
        map.put(new Student("aima", 30), "南京");
        map.put(new Student("zhaoliu", 26), "武汉");
        map.put(new Student("zhaoliu", 23), "深圳");
        map.put(new Student("zhangsan", 28), "济南");

        Set<Map.Entry<Student, String>> entrySet = map.entrySet();
        for (Iterator<Map.Entry<Student, String>> iterator = entrySet.iterator(); iterator.hasNext(); ) {
            Map.Entry<Student, String> entry = iterator.next();
            Student student = entry.getKey();
            String value = entry.getValue();
            System.out.println(student.getName() + ":" + student.getAge() + "---" + value);
        }
    }
}
