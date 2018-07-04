package cn.ksdshpx.javase.pattern.adapter.sxt;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/4
 * Time: 15:35
 * Description:客户端电脑，只支持USB接口，需要使用适配器调用PS/2接口
 */
public class Client {
    public void useKeyPrint(Target target){
        target.handle();
    }
    public static void main(String[] args) {
        Client client = new Client();
        //Target target = new Adapter();
        Adapee adapee = new Adapee();
        Target target = new Adapter2(adapee);
        client.useKeyPrint(target);
    }
}
