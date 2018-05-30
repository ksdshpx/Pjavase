package cn.ksdshpx.javase.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/30
 * Time: 21:25
 * Description:jvm可视化工具JConsole测试
 */
public class JConsoleTest {
    private byte[] bytes = new byte[128*1024];
    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("JConsole Start!!");
        fill(1000);
    }

    private static void fill(int i) {
        List<JConsoleTest> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new JConsoleTest());
        }
    }
}
