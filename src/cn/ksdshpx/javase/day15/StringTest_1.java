package cn.ksdshpx.javase.day15;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/26
 * Time: 9:39
 * Description:字符串练习1
 * 需求：给定一个字符串数组，按照字典顺序进行从小到大的排序
 */
public class StringTest_1 {
    public static void main(String[] args) {
        String[] arr = {"nba", "abc", "cba", "zz", "qq", "haha"};
        printArr(arr);
        sortStrArr(arr);
        printArr(arr);
    }

    public static void sortStrArr(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(String[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.print(arr[i] + "]");
            }
        }
        System.out.println();
    }
}
