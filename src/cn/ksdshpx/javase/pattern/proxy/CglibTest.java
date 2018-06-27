package cn.ksdshpx.javase.pattern.proxy;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/27
 * Time: 9:28
 * Description:Cglib测试类
 */
public class CglibTest {
    public static void main(String[] args) {
        SomeService target = new SomeService();
        CglibFactory cglibFactory = new CglibFactory(target);
        SomeService proxy = cglibFactory.myCglibCreator();
        String result = proxy.doFirst();
        System.out.println("result:" + result);
    }
}
