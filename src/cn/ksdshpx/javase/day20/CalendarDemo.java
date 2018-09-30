package cn.ksdshpx.javase.day20;

import java.util.Calendar;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/30
 * Time: 16:50
 * Description:日历类Calendar
 */
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        int week = c.get(Calendar.DAY_OF_WEEK);
        System.out.println(year + "年" + month + "月" + day + "日" + hour + "时" + minute + "分" + second + "秒 " + getWeek(week));
    }

    private static String getWeek(int week) {
        String[] weeks = {"", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        return weeks[week];
    }
}
