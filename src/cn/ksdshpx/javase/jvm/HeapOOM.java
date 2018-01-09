package cn.ksdshpx.javase.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/1/9
 * Time: 19:58
 * Description:测试堆内存溢出  -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemeoryError
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
