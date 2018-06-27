package cn.ksdshpx.javase.pattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/26
 * Time: 23:22
 * Description:
 */
public class CglibFactory implements MethodInterceptor {
    private SomeService target;

    public CglibFactory() {
    }

    public CglibFactory(SomeService target) {
        this.target = target;
    }

    public SomeService myCglibCreator(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return (SomeService) enhancer.create();
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object invoke = method.invoke(target, args);
        if (invoke != null){
            invoke = ((String)invoke).toUpperCase();
        }
        return invoke;
    }
}
