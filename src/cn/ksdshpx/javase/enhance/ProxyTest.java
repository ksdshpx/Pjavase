package cn.ksdshpx.javase.enhance;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/11
 * Time: 10:43
 * Description:动态代理类
 */
public class ProxyTest {
    public static void main(String[] args) {
        Class<?> proxyClass = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        //System.out.println(proxyClass.getName());
        System.out.println("===================constructors=====================");
       /* Constructor<?>[] constructors = proxyClass.getConstructors();
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
        }*/
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
    }
}
