package cn.ksdshpx.javase.day1617;

import java.util.Comparator;
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
        //自然排序，元素自身具有比较性
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person("zhangsan", 20));
        treeSet.add(new Person("lisi", 25));
        treeSet.add(new Person("wangwu", 20));
        treeSet.add(new Person("zhaoliu", 22));
        for (Iterator iterator = treeSet.iterator(); iterator.hasNext(); ) {
            Person person = (Person) iterator.next();
            System.out.println(person.getName() + "---" + person.getAge());
        }
        System.out.println("-------------------------");
        //比较器排序，让集合具有比较性（给集合初始化一个比较器）
        TreeSet treeSet2 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Person p1 = (Person) o1;
                Person p2 = (Person) o2;
                int temp = p1.getName().compareTo(p2.getName());
                return temp == 0 ? p1.getAge() - p2.getAge() : temp;
            }
        });
        treeSet2.add(new Person("zhangsan", 20));
        treeSet2.add(new Person("lisi", 25));
        treeSet2.add(new Person("wangwu", 20));
        treeSet2.add(new Person("wangwu", 18));
        treeSet2.add(new Person("zhaoliu", 22));
        for (Iterator iterator = treeSet2.iterator(); iterator.hasNext(); ) {
            Person person = (Person) iterator.next();
            System.out.println(person.getName() + "---" + person.getAge());
        }
    }
}
