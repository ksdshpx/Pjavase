package cn.ksdshpx.javase.day1617;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/13
 * Time: 9:52
 * Description:HashSet集合
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Person("zhangsan",20));
        hashSet.add(new Person("lisi",30));
        hashSet.add(new Person("wangwu",25));
        hashSet.add(new Person("zhaoliu",25));
        hashSet.add(new Person("zhangsan",20));
        for (Iterator iterator = hashSet.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
}
