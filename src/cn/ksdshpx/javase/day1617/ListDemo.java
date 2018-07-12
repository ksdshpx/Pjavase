package cn.ksdshpx.javase.day1617;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
        System.out.println("get:" + list.get(0));
        System.out.println("sublist:" + list.subList(1, 3));
        System.out.println(list);
        //list特有的取出方式
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("----------------------");
        //并发修改异常 ConcurrentModificationException
        /*Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if ("abc8".equals(obj)) {
                list.add("abc6");
            } else {
                System.out.println(obj);
            }
        }*/

        System.out.println("-----+++++-----+++++------");
        //使用ListIterator解决并发修改异常
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Object obj = listIterator.next();
            if ("abc8".equals(obj)) {
                listIterator.add("abc6");
            } else {
                System.out.println(obj);
            }
        }
        System.out.println("hasNext:" + listIterator.hasNext());//false
        System.out.println("hasPrevious:" + listIterator.hasPrevious());//true
        System.out.println(list);
    }
}
