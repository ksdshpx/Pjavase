package cn.ksdshpx.javase.day1617;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/12
 * Time: 9:54
 * Description:Vector集合
 */
public class VectorDemo {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.addElement("abc1");
        vector.addElement("abc2");
        vector.addElement("abc3");
        vector.addElement("abc4");
        //使用枚举迭代
        Enumeration enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println("使用枚举遍历：" + enumeration.nextElement());
        }
        //使用迭代器遍历
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println("使用迭代器遍历：" + iterator.next());
        }

    }
}
