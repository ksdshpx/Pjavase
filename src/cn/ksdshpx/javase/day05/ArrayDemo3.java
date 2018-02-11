package cn.ksdshpx.javase.day05;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/2/11
 * Time: 13:24
 * Description:选择排序
 */
public class ArrayDemo3 {
    public static void main(String[] args) {
        int[] arr = {35, 23, -89, 46, -3, 90, 36, 0};
        System.out.print("排序前:");
        printArr(arr);
        selectSort(arr);
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
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
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
