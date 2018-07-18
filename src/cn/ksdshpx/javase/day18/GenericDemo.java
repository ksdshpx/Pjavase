package cn.ksdshpx.javase.day18;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/18
 * Time: 11:20
 * Description:测试泛型接口
 */
public class GenericDemo {
    public static void main(String[] args) {
        Inter obj = new InterImpl();
        obj.show("abc");
        Inter<Integer> obj2 = new InterImpl2<>();
        obj2.show(66);
    }
}

interface Inter<T> {
    public void show(T t);
}

class InterImpl implements Inter<String> {

    @Override
    public void show(String s) {
        System.out.println(s);
    }
}

class InterImpl2<T> implements Inter<T> {

    @Override
    public void show(T t) {
        System.out.println(t);
    }
}