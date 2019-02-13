package com.antfin.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/12/26
 * Time: 20:50
 * 需求:
 * 打印int数组中第11大的数，和除前十个大数以外的所有数字的中位数，数组可能有重复的值。个数少于100个。
 * 可以在命令行执行，数组在命令行输入，或者在代码里都行。
 * 如：1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10 10  11 11 12 12 11 12  7 8 9 11
 * 第一大的数字是12， 第二大的是11，第三大的是10， 以此类推。
 */
public class InterviewDemo {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 11, 12, 7, 8, 9, 11, 13};
        //1.对数组进行排序
        Arrays.sort(arr);
        //2.对数组中的元素进行去重并返回去重后数组的长度
        int len = removeDuplicate(arr);
        //3.打印数组的第11大数
        System.out.println("数组的第十一大数为:" + printArr(arr, len, 11));
        //4.打印数组中除去前10个大数的中位数
        System.out.println("数组中除去前十个大数的中位数为：" + printMidArr(arr, len, 10));
    }

    /**
     * 对数组中的元素去重
     *
     * @param arr
     * @return 返回数组去重后的长度
     */
    public static int removeDuplicate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int index = 0;
        for (int i = 0, len = arr.length; i < len; i++) {
            if (set.add(arr[i])) {
                arr[index++] = arr[i];
            }
        }
        return index;
    }

    /**
     * 返回数组的第k大的数
     *
     * @param arr
     * @param len
     */
    public static int printArr(int[] arr, int len, int k) {
        if (len < k) {
            throw new RuntimeException("数组中不存在第" + k + "大的数！");
        }
        return arr[len - k];
    }

    /**
     * 返回数组中除去前k个大数的中位数
     *
     * @param arr
     * @param len
     * @param k
     */
    public static int printMidArr(int[] arr, int len, int k) {
        if (len < k) {
            throw new RuntimeException("数组中元素不够" + k + "个！");
        }
        //求出第k大的数
        int kMax = printArr(arr, len, k);
        //去除前k大的数后数组中元素个数
        int remainCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= kMax) {
                remainCount++;
            } else {
                break;
            }
        }
        return remainCount % 2 == 0 ? (arr[(remainCount - 1) / 2] + arr[remainCount / 2]) / 2 : arr[remainCount / 2];
    }
}
