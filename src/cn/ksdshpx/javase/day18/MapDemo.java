package cn.ksdshpx.javase.day18;

import java.util.*;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/14
 * Time: 10:45
 * Description:Map集合
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        //添加元素
        System.out.println(map.put(8, "张三"));//null
        System.out.println(map.put(8, "李四"));//张三
        map.put(1, "王五");
        map.put(2, "赵六");
        //删除元素
        //System.out.println(map.remove(2));//赵六
        //判断
        System.out.println(map.containsKey(2));//true
        //获取
        System.out.println(map.get(8));//李四
        System.out.println("-----------------------------------");
        //遍历map集合方式一
        Set<Integer> keySet = map.keySet();
        for (Iterator<Integer> iterator = keySet.iterator(); iterator.hasNext(); ) {
            Integer key = iterator.next();
            System.out.println(map.get(key));
        }
        System.out.println("-----------------------------------");
        //遍历map集合的方式二
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator(); iterator.hasNext(); ) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + "::" + entry.getValue());
        }

        //获取集合中的values
        Collection<String> values = map.values();
        for (String value:values) {
            System.out.println(value);
        }
    }
}
