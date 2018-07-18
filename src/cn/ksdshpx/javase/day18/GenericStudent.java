package cn.ksdshpx.javase.day18;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/18
 * Time: 10:18
 * Description:自定义泛型类以及泛型方法
 */
public class GenericStudent<T> {
    private T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public <W> void show(W obj){
        System.out.println(obj);
    }
}
