package cn.ksdshpx.javase.enhance;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/11
 * Time: 10:23
 * Description:测试枚举类
 */
public class EnumTest {
    public static void main(String[] args) {
        MyWeekDay sun = MyWeekDay.MON;
        System.out.println(sun.nextDay());
        WeekDay weekDay = WeekDay.FRI;
        System.out.println(weekDay);
        System.out.println(weekDay.name());
        System.out.println(weekDay.ordinal());
        System.out.println(WeekDay.valueOf("WED"));
        System.out.println(WeekDay.values().length);
        System.out.println("----------------");
        TrafficLamp lamp = TrafficLamp.RED;
        System.out.println(lamp.nextLamp().name());
    }
}
