package cn.ksdshpx.javase.day1617;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/8
 * Time: 14:13
 * Description:集合框架常用方法
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        //添加元素
        coll.add("abc1");
        coll.add(true);
        coll.add(123);
        System.out.println(coll);
        //删除元素
        coll.remove(true);
        System.out.println(coll);
        //清空集合
        coll.clear();
        System.out.println(coll);
    }
}
