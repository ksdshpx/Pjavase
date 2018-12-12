package cn.ksdshpx.javase.day22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/12/11
 * Time: 10:30
 * Description:转换流实现键盘录入
 * 需求：将键盘录入的信息转换为大写输出到控制台，若输入over结束
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            System.out.println(line.toUpperCase());
        }
    }
}
