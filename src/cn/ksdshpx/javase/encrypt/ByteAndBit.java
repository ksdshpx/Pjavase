package cn.ksdshpx.javase.encrypt;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/17
 * Time: 22:41
 * Description:Byte和Bit
 */
public class ByteAndBit {
    public static void main(String[] args) throws Exception {
        String input = "A";
        byte[] bytes = input.getBytes();
        System.out.println("一个英文占" + bytes.length + "个字节");//一个英文占1个字节
        for (byte by : bytes) {
            System.out.print(by + " ");
            String binary = Integer.toBinaryString(by);
            System.out.println(binary);
        }

        String input2 = "我";
        byte[] bytes2 = input2.getBytes();
        System.out.println("UTF-8编码下一个英文占" + bytes2.length + "个字节");//UTF-8编码下一个英文占3个字节
        for (byte by : bytes2) {
            System.out.print(by + " ");
            String binary = Integer.toBinaryString(by);
            System.out.println(binary);
        }

        String input3 = "我";
        byte[] bytes3 = input3.getBytes("GBK");
        System.out.println("GBK编码下一个英文占" + bytes3.length + "个字节");//GBK编码下一个英文占2个字节
        for (byte by : bytes3) {
            System.out.print(by + " ");
            String binary = Integer.toBinaryString(by);
            System.out.println(binary);
        }
    }
}
