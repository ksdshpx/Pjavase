package cn.ksdshpx.javase.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/1/9
 * Time: 20:30
 * Description:测试运行时常量池内存溢出 -XX:PermSize10m -XX:MaxPermSize10m
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
