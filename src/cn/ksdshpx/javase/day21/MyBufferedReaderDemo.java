package cn.ksdshpx.javase.day21;

import java.io.FileReader;
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/12/9
 * Time: 10:55
 * Description:自定义字符读取缓冲流
 */
public class MyBufferedReaderDemo {
    public static void main(String[] args) {
        MyBufferedReader bufferedReader = null;
        try {
            bufferedReader = new MyBufferedReader(new FileReader("d:\\SystemDemo.java"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
