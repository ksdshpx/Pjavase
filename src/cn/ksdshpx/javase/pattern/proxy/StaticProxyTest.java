package cn.ksdshpx.javase.pattern.proxy;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/25
 * Time: 14:34
 * Description:静态代理测试
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        SomeServiceImpl target = new SomeServiceImpl();
        String result = target.doFirst();
        System.out.println("result:" + result);
        System.out.println("----------------");
        ISomeService proxy = new ServiceProxy(target);
        String proxyResult = proxy.doFirst();
        System.out.println("proxyResult:" + proxyResult);
        //proxy.doSecond();
    }
}
