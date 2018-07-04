package cn.ksdshpx.javase.pattern.adapter;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/3
 * Time: 10:51
 * Description:
 */
public class CookerAdapt implements IWorkerAdapt {

    @Override
    public String work(Object worker) {
        return ((ICooker)worker).cook();
    }

    @Override
    public boolean supports(Object worker) {
        return (worker instanceof ICooker);
    }
}
