package cn.ksdshpx.javase.day24;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/2/16
 * Time: 10:02
 * Description:操作字节数组（内存）的流对象
 *         注意：ByteArrayInputStream以及ByteArrayOutputStream无需关闭流对象，因为不涉及调用底层资源
 */
public class ByteArrayStreamDemo {
    public static void main(String[] args) {
        ByteArrayInputStream bis = new ByteArrayInputStream("abcde".getBytes());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int by = 0;
        while((by = bis.read())!=-1){
            bos.write(by);
        }
        System.out.println(bos.toString());
    }
}
