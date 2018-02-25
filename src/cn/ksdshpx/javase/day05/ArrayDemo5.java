package cn.ksdshpx.javase.day05;

import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/2/25
 * Time: 15:40
 * Description:二分查找法（折半查找法）
 */
public class ArrayDemo5 {
    public static void main(String[] args) {
        int[] arr = {23, 15, 78, 39, 68, 93, 10};
        int index = binarySearch(arr, 93);
        int index2 = Arrays.binarySearch(arr, 93);
        System.out.println("index:" + index);
        System.out.println("index:" + index2);
    }

    public static int binarySearch(int[] arr, int key) {
        int min = 0;
        int max = arr.length - 1;
        int mid = 0;
        while (min <= max) {
            mid = (min + max) / 2;
            if (arr[mid] < key) {
                min = mid + 1;
            } else if (arr[mid] > key) {
                max = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
