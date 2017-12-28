package cn.ksdshpx.java8.lambda;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2017/12/28
 * Time: 20:48
 */
@FunctionalInterface
public interface HandleLong<T,R>{
    public R handle(T t1,T t2);
}
