package basic.types.Date;

import java.util.Calendar;

/**
 * Created by xjlin on 2017/5/19.
 */
public class CalendarMethod {
    public static void main(String[] args) {
        Calendar c2 = Calendar.getInstance(); //当前时间

//年份
        int year = c2.get(Calendar.YEAR);
//月份
        int month = c2.get(Calendar.MONTH) + 1;
//日期
        int date = c2.get(Calendar.DATE);
//小时
        int hour = c2.get(Calendar.HOUR_OF_DAY);
//分钟
        int minute = c2.get(Calendar.MINUTE);
//秒
        int second = c2.get(Calendar.SECOND);
//星期几
        int day = c2.get(Calendar.DAY_OF_WEEK);

        System.out.println("年份：" + year);

        System.out.println("月份：" + month);

        System.out.println("日期：" + date);

        System.out.println("小时：" + hour);

        System.out.println("分钟：" + minute);

        System.out.println("秒：" + second);

        System.out.println("星期：" + day);
    }
}
