package cn.ksdshpx.javase.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/1/9
 * Time: 20:46
 * Description:测试方法区内存溢出 -XX:PermSize10m -XX:MaxPermSize10m
 */
public class JavaMethodAreaOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(obj,args);
                }
            });
            enhancer.create();
        }
    }
}
