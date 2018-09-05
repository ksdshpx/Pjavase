package cn.ksdshpx.javase.enhance;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Vector;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/5
 * Time: 14:50
 * Description:通过反射得到泛型的实际参数类型
 */
public class GenericReflectionTest {
    public static void main(String[] args) throws NoSuchMethodException {
        Method method = GenericReflectionTest.class.getMethod("applyVector", Vector.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println(genericParameterType.getTypeName());
        }
        ParameterizedType pType = (ParameterizedType) genericParameterTypes[0];
        System.out.println("原始类型:" + pType.getRawType());
        System.out.println("参数类型:" + pType.getActualTypeArguments()[0]);
    }

    public static void applyVector(Vector<Date> vector) {

    }
}
