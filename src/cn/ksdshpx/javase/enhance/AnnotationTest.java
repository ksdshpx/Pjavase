package cn.ksdshpx.javase.enhance;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/27
 * Time: 15:59
 * Description:对应用了注解的类进行反射的类
 */
public class AnnotationTest {
    public static void main(String[] args) {
        if(AnnotationUse.class.isAnnotationPresent(Ksdshpx.class)){
            Ksdshpx annotation = AnnotationUse.class.getAnnotation(Ksdshpx.class);
            System.out.println(annotation.color());
            System.out.println(annotation.value());
            System.out.println(annotation.arrayAttr().length);
            System.out.println(annotation.lamp().nextLamp().name());
            System.out.println(annotation.annotationAttr().value());
        }
    }
}
