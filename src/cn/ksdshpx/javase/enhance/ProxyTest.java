package cn.ksdshpx.javase.enhance;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/11
 * Time: 10:43
 * Description:动态代理类
 */
public class ProxyTest {
    public static void main(String[] args) throws Exception {
        Class<?> proxyClass = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        //System.out.println(proxyClass.getName());
        System.out.println("===================constructors=====================");
        Constructor<?>[] constructors = proxyClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            String constructorName = constructor.getName();
            StringBuilder stringBuilder = new StringBuilder(constructorName);
            stringBuilder.append("(");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                stringBuilder.append(parameterType.getName()).append(",");
            }
            if (parameterTypes != null || parameterTypes.length > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append(")");
            System.out.println(stringBuilder.toString());
        }
        System.out.println("===================methods=====================");
        Method[] methods = proxyClass.getMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            StringBuilder stringBuilder = new StringBuilder(methodName);
            stringBuilder.append("(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                stringBuilder.append(parameterType.getName()).append(",");
            }
            if (parameterTypes != null && parameterTypes.length > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append(")");
            System.out.println(stringBuilder.toString());
        }

        System.out.println("===================instance=====================");
        Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
        Collection proxy = (Collection) constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        //System.out.println(proxy.size());
        System.out.println("===================newInstance=====================");
        final ArrayList target = new ArrayList();
        final Advice advice = new MyAdvice();
        Collection proxy2 = (Collection) getProxy(target, advice);
        proxy2.add("xiaoming");
        proxy2.add("xiaohong");
        System.out.println(proxy2.size());
        System.out.println(proxy2.getClass().getName());//com.sun.proxy.$Proxy0
    }

    private static Object getProxy(Object target, Advice advice) throws IllegalAccessException, InvocationTargetException {
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
