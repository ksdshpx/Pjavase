package cn.ksdshpx.javase.day05;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/2/25
 * Time: 17:53
 * Description:十进制转换为十六进制
 */
public class ArrayDemo6 {
    public static void main(String[] args) {
        toHex_2(60);
    }

    public static void toHex(int num) {
        for (int i = 0; i < 8; i++) {
            int temp = num & 15;//取最后四位
            if (temp > 9) {
                System.out.print((char) (temp - 10 + 'A'));
            } else {
                System.out.print(temp);
            }
            num = num >>> 4;//右移四位
        }
    }

    /**
     * 数组的应用：查表法实现十进制转换为十六进制
     *
     * @param num
     */
    public static void toHex_2(int num) {
        if (num == 0) {
            System.out.println("0");
            return;
        }
        char[] chs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] arr = new char[8];
        int pos = arr.length;
        while (num != 0) {
            int temp = num & 15;//取最后四位
            arr[--pos] = chs[temp];
            num = num >>> 4;
        }
        for (int i = pos; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

}
