package cn.ksdshpx.javase.day20;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/10/5
 * Time: 17:15
 * Description:字符输出流FileWriter
 */
public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("io.txt");
        fileWriter.write("abcde");
        fileWriter.close();
    }
}
