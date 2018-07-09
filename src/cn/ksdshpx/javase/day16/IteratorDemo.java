package cn.ksdshpx.javase.day16;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/9
 * Time: 21:54
 * Description:集合迭代器
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add("abc1");
        collection.add("abc2");
        collection.add("abc3");
        collection.add("abc4");
        /*Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        for (Iterator iterator = collection.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
}
