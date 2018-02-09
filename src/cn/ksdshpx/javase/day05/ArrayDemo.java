package cn.ksdshpx.javase.day05;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/2/9
 * Time: 10:18
 * Description:数组的遍历
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{23, 68, 35, 90};
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i] + ";");
        }
    }
}
