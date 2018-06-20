package cn.ksdshpx.javase.jvm;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/20
 * Time: 14:24
 * Description:垃圾回收引用计数法
 */
public class ReferenceCountTest {
    public ReferenceCountTest() {
        byte[] bytes = new byte[20 * 1024 * 1024];
    }

    private Object instace;

    public static void main(String[] args) {
        ReferenceCountTest r1 = new ReferenceCountTest();
        ReferenceCountTest r2 = new ReferenceCountTest();
        r1.instace = r2;
        r2.instace = r1;
        r1 = null;
        r2 = null;
        System.gc();
    }
}
