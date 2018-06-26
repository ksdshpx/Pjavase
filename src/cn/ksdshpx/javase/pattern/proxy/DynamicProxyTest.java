package cn.ksdshpx.javase.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/26
 * Time: 20:45
 * Description:动态代理测试
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        SomeServiceImpl target = new SomeServiceImpl();
        String result = target.doFirst();
        System.out.println("result:" + result);
        System.out.println("----------------");
        //ISomeService proxy = new ServiceProxy(target);
        ISomeService proxy = (ISomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),//目标类的类加载器
                target.getClass().getInterfaces(),//目标类实现的接口
                new InvocationHandler() {
                    /**
                     *
                     * @param proxy 代理类对象
                     * @param method 目标方法
                     * @param args 目标方法的参数列表
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result =  method.invoke(target, args);
                        if (result != null) {
                            result = ((String)result).toUpperCase();
                        }
                        return result;
                    }
                }
        );
        String proxyResult = proxy.doFirst();
        System.out.println("proxyResult:" + proxyResult);
        proxy.doSecond();
    }
}
