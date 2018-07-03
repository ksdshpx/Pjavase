package cn.ksdshpx.javase.pattern.adapter;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/3
 * Time: 10:28
 * Description:适配器实现类
 */
public class WorkerAdapt implements IWorkerAdapt {
    String workContent = "";
    @Override
    public String work(Object worker) {
        if(worker instanceof ICooker){
            workContent = ((ICooker)worker).cook();
        }else if(worker instanceof IProgrammer){
            workContent = ((IProgrammer)worker).program();
        }
        return workContent;
    }
}
