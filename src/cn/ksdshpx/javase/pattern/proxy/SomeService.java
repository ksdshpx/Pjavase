package cn.ksdshpx.javase.pattern.proxy;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/26
 * Time: 23:18
 * Description:CGLib目标类
 */
//目标类：没有实现接口
public class SomeService{

    public String doFirst() {
        System.out.println("doFirst()..");
        return "abcde";
    }

    public void doSecond() {
        System.out.println("doSecond()..");
    }
}

