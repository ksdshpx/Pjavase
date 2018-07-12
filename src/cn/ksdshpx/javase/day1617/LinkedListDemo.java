package cn.ksdshpx.javase.day1617;

import java.util.LinkedList;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/12
 * Time: 10:18
 * Description:LinkedList集合
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList link = new LinkedList();
        link.addFirst("abc1");
        link.addFirst("abc2");
        link.addFirst("abc3");
        link.addFirst("abc4");
        System.out.println(link);//[abc4, abc3, abc2, abc1]
        System.out.println(link.getFirst());//获取第一个但不删除  abc4
        System.out.println(link.getFirst());//abc4
        System.out.println(link.removeFirst());//获取第一个但删除 abc4
        System.out.println(link.removeFirst());//abc3
    }
}
