package cn.ksdshpx.javase.pattern.adapter.sxt;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/4
 * Time: 15:33
 * Description:类适配器，相当于USB接口和PS/2接口的转换器
 */
public class Adapter extends Adapee implements Target{
    @Override
    public void handle() {
        super.printWord();
    }
}
