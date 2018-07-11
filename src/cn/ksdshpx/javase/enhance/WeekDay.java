package cn.ksdshpx.javase.enhance;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/11
 * Time: 10:21
 * Description:使用普通类模拟枚举
 */
public abstract class WeekDay {
    private WeekDay() {
    }

    public static final WeekDay SUN = new WeekDay() {
        @Override
        public WeekDay nextDay() {
            return MON;
        }
    };

    public static final WeekDay MON = new WeekDay() {
        @Override
        public WeekDay nextDay() {
            return SUN;
        }
    };

    public abstract WeekDay nextDay();

    public String toString() {
        return this == SUN ? "SUN" : "MON";
    }
}
