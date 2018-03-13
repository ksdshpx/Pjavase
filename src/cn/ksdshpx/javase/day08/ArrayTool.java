package cn.ksdshpx.javase.day08;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/3/13
 * Time: 13:36
 * Description:操作数组的工具类
 * @author peng.x
 * @version v1.0
 */
public class ArrayTool {
    /**
     * 获取数组中的最大值
     * @param arr 接收一个元素为int类型的数组
     * @return 返回该数组中的最大的元素值
     */
    public static int getMax(int[] arr){
        int maxIndex = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if(arr[i] > arr[maxIndex]){
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }
}
