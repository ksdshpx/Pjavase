package cn.ksdshpx.javase.day19;

import java.util.Arrays;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/25
 * Time: 10:43
 * Description:数组工具类
 */
public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 5, 8, 3};
        String[] strArr = {"abc", "zhangsan", "lisi"};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(strArr));
        List<int[]> list = Arrays.asList(arr);
        List<String> strList = Arrays.asList(strArr);
        System.out.println("size:" + list.size());//1,因为集合中不能存储基本数据类型，所以当数组中的元素为基本数据类型时，存到集合中的是作为一个整体的数组
        System.out.println("strSize:" + strList.size());//3
        //list.add(99);//java.lang.UnsupportedOperationException,报异常，因为数组的长度不能改变
        System.out.println("contains:" + list.contains(8));
    }
}
