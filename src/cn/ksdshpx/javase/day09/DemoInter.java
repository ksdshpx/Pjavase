package cn.ksdshpx.javase.day09;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/3/28
 * Time: 13:25
 * Description:接口
 *              接口中的元素
 *                      ---常量  public static final
 *                      ---抽象方法  public abstract
 *              作用：接口避免了单继承的局限性。(多实现)
 *              注意：类与类之间是继承的关系（只能单继承），
 *                      类与接口之间是实现的关系（可以多实现），
 *                      接口与接口之间是继承的关系（可以多继承）
 */
public interface DemoInter {
    public abstract  void show();
}
