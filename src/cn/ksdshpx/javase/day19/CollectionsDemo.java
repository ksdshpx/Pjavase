package cn.ksdshpx.javase.day19;

import java.util.*;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/24
 * Time: 10:33
 * Description:集合框架工具类
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("cbad");
        list.add("nbaad");
        list.add("cbad");
        list.add("difddf");
        System.out.println("max=" + Collections.max(list));
        System.out.println("maxbylength=" + Collections.max(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int temp = o1.length() - o2.length();
                return temp == 0 ? o1.compareTo(o2) : temp;
            }
        }));
        //Collections.sort(list);
        //mySort(list);
        mySort2(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int temp = o1.length() - o2.length();
                return temp == 0 ? o1.compareTo(o2) : temp;
            }
        });
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }

        //二分查找（必须有序）
        int index = Collections.binarySearch(list, "abd");
        System.out.println("index = " + index);
    }

    public static <T extends Comparable<? super T>> void mySort(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }

    public static <T extends Comparable<? super T>> void mySort2(List<T> list, Comparator<? super T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(i), list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
