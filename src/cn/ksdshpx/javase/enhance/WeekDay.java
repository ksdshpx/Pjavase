package cn.ksdshpx.javase.enhance;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/11
 * Time: 10:40
 * Description:定义枚举类
 */
public enum WeekDay {
    SUN(1), MON, TUE, WED, THI, FRI, SAT;

    private WeekDay() {
        System.out.println("first...");
    }

    private WeekDay(int day) {
        System.out.println("second...");
    }
}
