package cn.ksdshpx.javase.jvm;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/11/26
 * Time: 14:11
 * Description:测试JVM内存大小
 *             -Xms1024m -Xmx1024m -XX:+PrintGCDetails
 */
public class GuiGuJVM {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("jvm虚拟机最大的内存大小为(默认为物理内存的1/4):" + (maxMemory / 1024 / 1204) + "MB");
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("jvm虚拟机初始化的内存大小为(默认为物理内存的1/64):" + (totalMemory / 1024 / 1204) + "MB");
    }
}
