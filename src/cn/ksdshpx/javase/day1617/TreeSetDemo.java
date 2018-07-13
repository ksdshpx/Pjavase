package cn.ksdshpx.javase.day1617;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/13
 * Time: 17:13
 * Description:TreeSet集合
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person("zhangsan", 20));
        treeSet.add(new Person("lisi", 25));
        treeSet.add(new Person("wangwu", 20));
        treeSet.add(new Person("zhaoliu", 22));
        for (Iterator iterator = treeSet.iterator(); iterator.hasNext(); ) {
            Person person = (Person) iterator.next();
            System.out.println(person.getName() + "---" + person.getAge());
        }
    }
}
