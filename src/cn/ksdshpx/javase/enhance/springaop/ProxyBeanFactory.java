package cn.ksdshpx.javase.enhance.springaop;

import cn.ksdshpx.javase.enhance.Advice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/13
 * Time: 10:34
 * Description:代理类工厂
 */
public class ProxyBeanFactory {
    private Object target;
    private Advice advice;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public Object getProxy() throws IllegalAccessException, InvocationTargetException {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                advice.beforeMethod(method);
                Object retVal = method.invoke(target, args);
                advice.afterMethod(method);
                return retVal;
            }
        });
    }
}
