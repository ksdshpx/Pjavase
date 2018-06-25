package cn.ksdshpx.javase.pattern.proxy;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/25
 * Time: 14:32
 * Description:静态代理接口类
 */
//主业务接口，本接口中的方法将要被代理增强
public interface ISomeService {
    public abstract String doFirst();
    public abstract void doSecond();
}
