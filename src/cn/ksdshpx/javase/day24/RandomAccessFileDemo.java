package cn.ksdshpx.javase.day24;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/2/15
 * Time: 9:44
 * Description:随机访问文件对象
 *             1.该对象既可以读，也可以写
 *             2.该对象内部维护了一个byte[]数组，并通过指针可以操作数组中的元素
 *             3.可以通过getFilePointer方法获取指针的位置，也可以通过seek方法设置指针的位置
 *             4.其实该对象就是将字节输入流和字节输出流进行了封装
 *             5.该对象的源或目的只能是文件。通过构造函数就可以看出
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        //writeFile();
        readFile();
    }

    public static void readFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("d:\\ranacc.txt","r");
        //通过seek设置指针的位置
        raf.seek(10);
        byte[] buf = new byte[6];
        raf.read(buf);
        String name = new String(buf);
        System.out.println("name:"+name);
        int age = raf.readInt();
        System.out.println("age:"+age);
        System.out.println("pos:"+raf.getFilePointer());
        raf.close();
    }

    //使用RandomAccessFile对象写入一些人员信息，比如姓名和年龄
    public static void writeFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("d:\\ranacc.txt","rw");
        raf.write("张三".getBytes());
        raf.writeInt(97);
        raf.write("小强".getBytes());
        raf.writeInt(99);
        raf.close();
    }
}
