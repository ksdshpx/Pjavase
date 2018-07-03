package cn.ksdshpx.javase.pattern.adapter;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/3
 * Time: 10:10
 * Description:IProgrammer的实现类
 */
public class TxProgrammer implements IProgrammer{
    @Override
    public String program() {
        return "编写java程序";
    }
}
