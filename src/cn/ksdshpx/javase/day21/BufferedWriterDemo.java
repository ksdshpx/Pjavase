package cn.ksdshpx.javase.day21;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/12/9
 * Time: 10:30
 * Description:字符写入缓冲流
 */
public class BufferedWriterDemo {
    public static void main(String[] args) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("d:\\buff.txt"));
            bufferedWriter.write("abcd");
            bufferedWriter.newLine();
            bufferedWriter.write("efg");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
