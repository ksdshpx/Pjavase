package cn.ksdshpx.javase.enhance;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/11
 * Time: 10:21
 * Description:使用普通类模拟枚举
 */
public abstract class MyWeekDay {
    private MyWeekDay() {
    }

    public static final MyWeekDay SUN = new MyWeekDay() {
        @Override
        public MyWeekDay nextDay() {
            return MON;
        }
    };

    public static final MyWeekDay MON = new MyWeekDay() {
        @Override
        public MyWeekDay nextDay() {
            return SUN;
        }
    };

    public abstract MyWeekDay nextDay();

    public String toString() {
        return this == SUN ? "SUN" : "MON";
    }
}
