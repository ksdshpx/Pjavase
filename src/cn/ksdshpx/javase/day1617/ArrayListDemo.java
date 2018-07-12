package cn.ksdshpx.javase.day1617;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/12
 * Time: 15:12
 * Description:ArrayList存储自定义对象
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Person("zhangsan", 30));
        arrayList.add(new Person("lisi", 26));
        arrayList.add(new Person("wangwu", 36));
        arrayList.add(new Person("zhaoliu", 18));
        for (Iterator iterator = arrayList.iterator(); iterator.hasNext(); ) {
            Person person = (Person) iterator.next();
            System.out.println(person.getName() + "----" + person.getAge());
        }
    }
}
