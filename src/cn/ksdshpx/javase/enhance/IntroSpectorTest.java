package cn.ksdshpx.javase.enhance;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/20
 * Time: 10:04
 * Description:内省案例
 */
public class IntroSpectorTest {
    public static void main(String[] args) throws Exception {
        ReflectPoint rp = new ReflectPoint(3, 5);
        String propertyName = "x";
        Object retVal = getProperty(rp, propertyName);
        System.out.println(retVal);
        System.out.println("------------------------");
        int value = 88;
        setProperty(rp, propertyName, value);
        System.out.println(rp.getX());
        System.out.println("------------------------");
        BeanInfo beanInfo = Introspector.getBeanInfo(rp.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            if(propertyDescriptor.getName().equals(propertyName)){
                Method methodGetX = propertyDescriptor.getReadMethod();
                Object retVal2 = methodGetX.invoke(rp);
                System.out.println(retVal2);
            }
        }
        System.out.println(rp.getX());
    }

    private static void setProperty(ReflectPoint rp, String propertyName, int value) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        PropertyDescriptor pd2 = new PropertyDescriptor(propertyName, rp.getClass());
        Method methodSetX = pd2.getWriteMethod();
        methodSetX.invoke(rp, value);
    }

    private static Object getProperty(Object rp, String propertyName) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        PropertyDescriptor pd1 = new PropertyDescriptor(propertyName, rp.getClass());
        Method methodGetX = pd1.getReadMethod();
        return methodGetX.invoke(rp);
    }
}
