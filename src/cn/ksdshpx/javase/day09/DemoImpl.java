package cn.ksdshpx.javase.day09;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/3/28
 * Time: 13:29
 * Description:
 */
public class DemoImpl implements DemoInter {
    @Override
    public void show() {
        System.out.println("show...");
    }

    public static void main(String[] args) {
        DemoImpl d = new DemoImpl();
        d.show();
    }
}
