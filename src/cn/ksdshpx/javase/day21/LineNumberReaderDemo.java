package cn.ksdshpx.javase.day21;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/12/10
 * Time: 9:23
 * Description:带行号的字符读取缓冲流
 */
public class LineNumberReaderDemo {
    public static void main(String[] args) throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader("d:\\SystemDemo.java"));
        lnr.setLineNumber(100);
        String line = null;
        while ((line = lnr.readLine()) != null) {
            System.out.println(lnr.getLineNumber() + ":" + line);
        }
        lnr.close();
    }
}
