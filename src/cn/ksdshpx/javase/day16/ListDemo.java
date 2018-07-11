package cn.ksdshpx.javase.day16;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/11
 * Time: 10:58
 * Description:List集合
 */
public class ListDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        System.out.println(list);
        System.out.println("remove:" + list.remove(2));
        list.add(1, "abc9");
        System.out.println("set:" + list.set(1, "abc8"));
        System.out.println("get:"+list.get(0));
        System.out.println("sublist:"+list.subList(1,3));
        System.out.println(list);
    }
}
