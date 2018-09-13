package cn.ksdshpx.javase.enhance.springaop;

import java.io.InputStream;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/13
 * Time: 10:41
 * Description:测试自己写的SpringAop
 */
public class SpringAopTest {
    public static void main(String[] args) {
        InputStream inputStream = SpringAopTest.class.getClassLoader().getResourceAsStream("bean.properties");
        BeanFactory beanFactory = new BeanFactory(inputStream);
        Object bean = beanFactory.getBean("xxx");
        System.out.println(bean.getClass().getName());
    }
}
