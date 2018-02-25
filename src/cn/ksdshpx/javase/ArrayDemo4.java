package cn.ksdshpx.javase;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/2/25
 * Time: 14:27
 * Description:数组的操作：查找
 */
public class ArrayDemo4 {
    public static void main(String[] args) {
        int[] arr = {90, 34, 87, 46, 32, 97, 64};
        int index = getIndex(arr, 87);
        System.out.println("index:" + index);
    }

    public static int getIndex(int[] arr, int ele) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele) {
                return i;
            }
        }
        return -1;
    }
}
