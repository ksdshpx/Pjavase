package cn.ksdshpx.javase.day21;

import java.io.FileReader;
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/12/9
 * Time: 16:28
 * Description:自定义BufferedReader
 */
public class MyBufferedReader {
    private FileReader fileReader;
    private char[] buf = new char[1024];
    private int pos = 0;
    private int count = 0;

    public MyBufferedReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public int read() throws IOException {
        if (count == 0) {
            count = fileReader.read(buf);
            pos = 0;
        }
        if (count < 0) {
            return -1;
        }
        int ch = buf[pos++];
        count--;
        return ch;
    }

    public String readLine() throws IOException {
        StringBuffer sb = new StringBuffer();
        int ch = 0;
        while ((ch = read()) != -1) {
            if (ch == '\r')
                continue;
            if (ch == '\n')
                return sb.toString();
            sb.append((char) ch);
        }
        if (sb.length() != 0) {
            return sb.toString();
        }
        return null;
    }

    public void close() throws IOException {
        fileReader.close();
    }
}
