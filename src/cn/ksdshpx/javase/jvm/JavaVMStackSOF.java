package cn.ksdshpx.javase.jvm;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/1/9
 * Time: 20:14
 * Description:测试StackOverFlowError -Xss128k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
