package cn.ksdshpx.javase.day22;

import java.io.IOException;
import java.io.InputStream;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/12/11
 * Time: 10:30
 * Description:键盘录入
 * 需求：将键盘录入的信息转换为大写输出到控制台，若输入over结束
 */
public class SystemInDemo {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        StringBuilder sb = new StringBuilder();
        int ch = 0;
        while ((ch = in.read()) != -1) {
            if (ch == '\r') {
                continue;
            }
            if (ch == '\n') {
                String str = sb.toString();
                if ("over".equals(str)) {
                    break;
                }
                System.out.println(str.toUpperCase());
                sb.delete(0, sb.length());
            } else {
                sb.append((char) ch);
            }
        }
    }
}
