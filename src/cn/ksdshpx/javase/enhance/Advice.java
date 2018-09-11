package cn.ksdshpx.javase.enhance;

import java.lang.reflect.Method;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/11
 * Time: 16:11
 * Description:Advice接口
 */
public interface Advice {
    public abstract void beforeMethod(Method method);
    public abstract void afterMethod(Method method);
}
