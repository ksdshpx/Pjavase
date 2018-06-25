package cn.ksdshpx.javase.pattern.proxy;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/25
 * Time: 14:35
 * Description:静态代理类
 */
public class ServiceProxy implements ISomeService {
    private ISomeService target;

    public ServiceProxy() {
    }

    public ServiceProxy(ISomeService target) {
        this.target = target;
    }

    @Override
    public String doFirst() {
        //调用目标对象的目标方法，该方法返回全小写字母
        String result = target.doFirst();
        //将目标对象方法返回的全小写字母变成大写
        result = result.toUpperCase();
        return result;
    }

    @Override
    public void doSecond() {
        target.doSecond();
    }
}
