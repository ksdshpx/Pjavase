package cn.ksdshpx.javase.day24;

import java.io.*;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/2/16
 * Time: 9:46
 * Description:操作基本数据类型的流对象
 */
public class DataStreamDemo {
    public static void main(String[] args) throws IOException {
        //writeFile();
        readFile();
    }

    public static void readFile() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("d:\\data.txt"));
        String str = dis.readUTF();
        System.out.println(str);
    }

    public static void writeFile() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("d:\\data.txt"));
        dos.writeUTF("你好");
        dos.close();
    }
}
