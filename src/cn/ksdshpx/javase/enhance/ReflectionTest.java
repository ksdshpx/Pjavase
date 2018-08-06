package cn.ksdshpx.javase.enhance;

import java.lang.reflect.Field;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/6
 * Time: 14:53
 * Description:反射案例
 * 需求：将任意一个对象中的所有String类型的成员变量所对应的字符串字段值中的"a"改成"b"
 */
public class ReflectionTest {
    public static void main(String[] args) throws IllegalAccessException {
        Point point = new Point();
        String result = changeStringField(point);
        System.out.println("result = " + result);
    }

    private static <T> String changeStringField(T t) throws IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder();
        Class<?> clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if ("java.lang.String".equals(field.getType().getName())) {
                field.setAccessible(true);
                String fieldName = field.getName();
                String returnFieldName = fieldName == null ? "" : fieldName.replace('a', 'b');
                stringBuilder.append(returnFieldName + " ");
            }
        }
        return stringBuilder.toString();
    }
}
