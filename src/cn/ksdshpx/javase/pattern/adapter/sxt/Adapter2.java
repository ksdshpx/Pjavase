package cn.ksdshpx.javase.pattern.adapter.sxt;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/4
 * Time: 15:46
 * Description:对象适配器，相当于USB接口和PS/2接口的转换器
 */
public class Adapter2 implements Target{
    private Adapee adapee;

    public Adapter2(Adapee adapee) {
        this.adapee = adapee;
    }

    @Override
    public void handle() {
        adapee.printWord();
    }
}
