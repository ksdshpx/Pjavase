package cn.ksdshpx.javase.day20;

import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/27
 * Time: 14:14
 * Description:Runtime类常用方法
 */
public class RuntimeDemo {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        try {
            r.exec("notepad.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
