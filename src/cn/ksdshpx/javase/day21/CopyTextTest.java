package cn.ksdshpx.javase.day21;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/12/8
 * Time: 16:48
 * Description:从c盘复制一个文本文件到d盘
 */
public class CopyTextTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("c:\\FileReaderDemo.java");
            fileWriter = new FileWriter("d:\\copy_1.java");
            int ch = 0;
            while ((ch = fileReader.read()) != -1) {
                fileWriter.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
