package cn.ksdshpx.javase.mycollection;

import java.util.HashMap;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/10/13
 * Time: 21:31
 * Description:自定义HashSet
 *                  HashSet底层是一个HashMap
 */
public class MyHashSet {
    private HashMap hashMap;
    private static final Object PRESENT = new Object();

    public MyHashSet() {
        hashMap = new HashMap();
    }

    public int size() {
        return hashMap.size();
    }

    public void add(Object obj) {
        hashMap.put(obj, PRESENT);
    }
}
