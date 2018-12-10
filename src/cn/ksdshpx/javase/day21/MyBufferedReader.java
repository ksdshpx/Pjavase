package cn.ksdshpx.javase.day21;

import java.io.IOException;
import java.io.Reader;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/12/9
 * Time: 16:28
 * Description:自定义BufferedReader（使用装饰者模式）
 */
public class MyBufferedReader extends Reader{
    private Reader reader;
    private char[] buf = new char[1024];
    private int pos = 0;
    private int count = 0;

    public MyBufferedReader(Reader reader) {
        this.reader = reader;
    }

    public int read() throws IOException {
        if (count == 0) {
            count = reader.read(buf);
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
        reader.close();
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }
}
