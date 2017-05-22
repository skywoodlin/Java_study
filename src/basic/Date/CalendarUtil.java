package basic.Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by xjlin on 2017/5/19.
 */
public class CalendarUtil {
    public static final String round = "1";
    public static final String roundUp = "2";
    public static final String roundDown = "3";

    public static void main(String[] args) {
        Calendar d1 = Calendar.getInstance();
        Calendar d2 = Calendar.getInstance();

        d2.set(2011, 3-1, 4, 11,11,11);

        System.out.println("浮点数： " + CalendarUtil.countFloatInterval(d1, d2));
        System.out.println("四舍五入： " + CalendarUtil.countIntInterval(d1, d2, CalendarUtil.round));
        System.out.println("向上取整： " + CalendarUtil.countIntInterval(d1, d2, CalendarUtil.roundUp));
        System.out.println("向下取整： " + CalendarUtil.countIntInterval(d1, d2, CalendarUtil.roundDown));


        String str1 = "2017/05/19";
        String str2 = "1983/07/18";
        try{
            System.out.println("今天距我生日已经： " + CalendarUtil.countIntervalForStringTypeDate(str1, str2, "yyyy/MM/dd", CalendarUtil.round) + "天");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 计算两个日期相差天数, 值为小数类型
     */
    public static double countFloatInterval(Calendar startDate, Calendar endDate) {
        //确保startday在endday之前
        if (startDate.after(endDate)) {
            Calendar calTmp = startDate;
            startDate = endDate;
            endDate = calTmp;
        }

        long s1 = startDate.getTimeInMillis();
        long e1 = endDate.getTimeInMillis();
        double days = (double)(e1 - s1) / (24 * 60 * 60 * 1000);

        return days;
    }

    /**
     * 计算两个日期相差天数, 顺序没有关系， 结果天数为int型， 根据mode的不同实行四舍五入， 向上， 向下取整
     * @param startDate
     * @param endDate
     * @param mode CalendarUtil.round      四舍五入
     * @param mode CalendarUtil.roundUp    向上取整
     * @param mode CalendarUtil.roundDown  向下取整
     * @return
     */
    public static int countIntInterval(Calendar startDate, Calendar endDate, String mode) {
        //确保startday在endday之前
        if (startDate.after(endDate)) {
            Calendar calTmp = startDate;
            startDate = endDate;
            endDate = calTmp;
        }

        long s1 = startDate.getTimeInMillis();
        long e1 = endDate.getTimeInMillis();
        double days = (double)(e1 - s1) / (24 * 60 * 60 * 1000);

        double intervals = 0.00;
        //返回整数天数
        if (CalendarUtil.round.equals(mode)) {
            //四舍五入
            intervals = Math.round(days);
            return (int) intervals;
        } else if (CalendarUtil.roundUp.equals(mode)) {
            //向上取整
            intervals = Math.ceil(days);
            return (int) intervals;
        } else {
            //向下取整
            intervals = Math.floor(days);
            return (int) intervals;
        }
    }

    /**
     * 计算两个字符串型的日期间隔天数， 前后顺序无所谓
     * 将String转Date， 再转Calendar
     * @param date1
     * @param date2
     * @param format 字符串格式： SimpleDateFormat可用的字符串格式
     * @param mode
     * @return
     * @throws Exception
     */
    public static int countIntervalForStringTypeDate(String date1, String date2, String format, String mode) throws Exception{
        Date dateTmp1= null;
        Date dateTmp2 = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            dateTmp1 = sdf.parse(date1);
            dateTmp2 = sdf.parse(date2);
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception("日期格式错误！");
        }

        // 转
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.setTime(dateTmp1);
        endDate.setTime(dateTmp2);

        //确保startday在endday之前
        if (startDate.after(endDate)) {
            Calendar calTmp = startDate;
            startDate = endDate;
            endDate = calTmp;
        }

        return CalendarUtil.countIntInterval(startDate, endDate, mode);
    }
}
