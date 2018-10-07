package cn.ksdshpx.javase.day20;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/10/7
 * Time: 9:16
 * Description:字符输入流FileReader
 */
public class FileReaderDemo {
    @Test
    public void readByChar() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("io.txt");
            int ch = 0;
            while ((ch = fileReader.read()) != -1) {
                System.out.println((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void readByCharArray() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("io.txt");
            char[] buf = new char[1024];
            int len = 0;
            while ((len = fileReader.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
