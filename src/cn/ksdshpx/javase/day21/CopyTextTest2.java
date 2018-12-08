package cn.ksdshpx.javase.day21;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/12/8
 * Time: 16:48
 * Description:从c盘复制一个文本文件到d盘（方法二）
 */
public class CopyTextTest2 {
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("c:\\FileReaderDemo.java");
            fileWriter = new FileWriter("d:\\copy_2.java");
            int len = 0;
            char[] chs = new char[1024];
            while ((len = fileReader.read(chs)) != -1) {
                fileWriter.write(chs, 0, len);
            }
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

            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
