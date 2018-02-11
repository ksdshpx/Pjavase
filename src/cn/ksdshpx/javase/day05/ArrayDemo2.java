package cn.ksdshpx.javase.day05;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/2/11
 * Time: 12:50
 * Description:获取数组的最大值
 */
public class ArrayDemo2 {
    public static void main(String[] args) {
        int[] arr = {11, -3, 199, -342, 234, -89};
        System.out.println("max=" + getMax(arr));
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
