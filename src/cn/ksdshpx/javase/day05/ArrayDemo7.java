package cn.ksdshpx.javase.day05;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/2/25
 * Time: 19:04
 * Description:进制转换整合（十进制转换为任意常见进制）
 */
public class ArrayDemo7 {
    public static void main(String[] args) {
        toHex(60);
        toBinary(6);
        toOctal(60);
    }

    public static void toHex(int num) {
        trans(num, 15, 4);
    }

    public static void toBinary(int num) {
        trans(num, 1, 1);
    }

    public static void toOctal(int num) {
        trans(num, 7, 3);
    }

    public static void trans(int num, int base, int offset) {
        if (num == 0) {
            System.out.println("0");
            return;
        }
        char[] chs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] arr = new char[8];
        int pos = arr.length;
        while (num != 0) {
            int temp = num & base;//取最后四位
            arr[--pos] = chs[temp];
            num = num >>> offset;
        }
        for (int i = pos; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
