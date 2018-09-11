package cn.ksdshpx.javase.enhance;

import java.lang.reflect.Method;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/11
 * Time: 16:12
 * Description:MyAdvice类
 */
public class MyAdvice implements Advice {
    private long beginTime;

    @Override
    public void beforeMethod(Method method) {
        System.out.println("到传智播客来学习了！");
        beginTime = System.currentTimeMillis();
    }

    @Override
    public void afterMethod(Method method) {
        long endTime = System.currentTimeMillis();
        System.out.println(method.getName() + " costs " + (endTime - beginTime));
        System.out.println("从传智播客毕业上班了！");
    }
}
