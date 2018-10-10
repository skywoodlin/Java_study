package basic.otherAPI;

import java.util.Calendar;

/**
 * Created by xjlin on 2018/9/11.
 * <p>
 * 月份： 0~11
 */
public class CalendarDemo{
    public static void main(String[] args){
        Calendar now = Calendar.getInstance();
        System.out.println(CalendarDemo.showDateInfo(now));

        //设置日期, 注意月份从0开始
        Calendar c1 = Calendar.getInstance();
        c1.set(1983,6,27); //19830727
        System.out.println(CalendarDemo.showDateInfo(c1));
        c1.set(1983,8,29); //19830929
        System.out.println(CalendarDemo.showDateInfo(c1));
        c1.set(2013,9,2); //20131002
        System.out.println(CalendarDemo.showDateInfo(c1));

        //指定偏移量
        c1.add(Calendar.YEAR, 4); //推后4年
        System.out.println(CalendarDemo.showDateInfo(c1)); //20171002
        c1.add(Calendar.MONTH, 3); //退后3月
        System.out.println(CalendarDemo.showDateInfo(c1)); //20180102

//        //试试公元前
//        c1.set(Calendar.YEAR, -209);
//        System.out.println(CalendarDemo.showDateInfo(c1)); //210年1月2日 星期三
//        System.out.println(c1.get(Calendar.ERA));
//        c1.set(Calendar.YEAR, 209);
//        System.out.println(CalendarDemo.showDateInfo(c1)); //210年1月2日 星期三
//        System.out.println(c1.get(Calendar.ERA));

        //某年某月有几天
        System.out.println(CalendarDemo.showDaysNum(2018, 2));
        System.out.println(CalendarDemo.showDaysNum(2018, 3));





    }

    /**
     * 显示今天日期及星期几， 注意星期日为1， 星期六为7
     *
     * @param c
     * @return
     */
    public static String showDateInfo(Calendar c){
//        int era =
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1; //9月份显示8
        int day = c.get(Calendar.DAY_OF_MONTH);
        int week = c.get(Calendar.DAY_OF_WEEK);
        String[] dayArr = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

        return year + "年" + month + "月" + day + "日 " + dayArr[week - 1];
    }



    /**
     * 任意给定yyyy年， 它的nn月（1~12）有多少天
     */
    public static int showDaysNum(int year, int month) {
        if(year < 0 || month <1 || month > 12) {
            throw new myException("年月输入不对");
        }

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month); //下一个月
        c.set(Calendar.DATE, 1); //1号
        c.add(Calendar.DATE, -1); //减一天

        return c.get(Calendar.DATE);
    }

    /**
     *
     */


}

class myException extends RuntimeException  {
    public myException(String message) {
        super(message);
    }

}
