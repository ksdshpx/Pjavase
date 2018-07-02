package cn.ksdshpx.javase.jvm;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/29
 * Time: 14:21
 * Description:测试内存分配之Eden区
 * -verbose:gc
 * -XX:+PrintGCDetails
 * -XX:+UseSerialGC
 */
public class EdenTest {
    public static void main(String[] args) {
        byte[] bytes = new byte[40 * 1024 *1024];
    }
}
