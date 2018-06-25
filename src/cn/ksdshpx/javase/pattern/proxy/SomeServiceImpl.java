package cn.ksdshpx.javase.pattern.proxy;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/25
 * Time: 14:33
 * Description:静态代理目标类
 */
//目标类：代理类将要增强的类
public class SomeServiceImpl implements ISomeService{
    @Override
    public String doFirst() {
        System.out.println("doFirst()..");
        return "abcde";
    }

    @Override
    public void doSecond() {
        System.out.println("doSecond()..");
    }
}
