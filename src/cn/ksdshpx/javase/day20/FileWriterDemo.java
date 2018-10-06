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
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("io.txt", true);
            fileWriter.write("abc" + System.getProperty("line.separator") + "de");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
