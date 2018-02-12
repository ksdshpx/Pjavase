package cn.ksdshpx.javase.day05;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/2/11
 * Time: 13:24
 * Description:选择排序、冒泡排序以及排序性能优化
 */
public class ArrayDemo3 {
    public static void main(String[] args) {
        int[] arr = {35, 23, -89, 46, -3, 90, 36, 0};
        System.out.print("排序前:");
        printArr(arr);
        //selectSort(arr);
        selectSort_2(arr);
//        bubbleSort(arr);
        System.out.print("排序后:");
        printArr(arr);
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(arr, i, j);
            }
        }
    }

    /**
     * 选择排序优化
     *
     * @param arr
     */
    public static void selectSort_2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            int num = arr[index];
            for (int j = i + 1; j < arr.length; j++) {
                if (num > arr[j]) {
                    index = j;
                    num = arr[index];
                }
            }
            if (index != i) {
                swap(arr, i, index);
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.println(arr[i] + "]");
            }
        }
    }
}
