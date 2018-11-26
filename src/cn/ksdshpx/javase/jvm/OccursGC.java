package cn.ksdshpx.javase.jvm;

import java.util.Random;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/11/26
 * Time: 14:23
 * Description:测试触发各种GC的时间点
 *             -Xms8m -Xmx8m -XX:+PrintGCDetails
 */
public class OccursGC {
    public static void main(String[] args) {
        String str = "www.sfit.shfe.com";
        while (true){
            str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999);
        }
    }
}
