package cn.ksdshpx.javase.pattern.adapter;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/3
 * Time: 10:14
 * Description:测试程序
 */
public class MyTest {
    public static void main(String[] args) {
        ICooker qjdCooker = new QjdCooker();
        IProgrammer txProgrammer = new TxProgrammer();
        System.out.println(qjdCooker.cook());
        System.out.println(txProgrammer.program());
        Object[] workers = {qjdCooker, txProgrammer};
        IWorkerAdapt adapt = new WorkerAdapt();
        for (Object worker : workers) {
            String workContent = adapt.work(worker);
            System.out.println(workContent);
        }
    }
}
