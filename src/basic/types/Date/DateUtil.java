package basic.types.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * 日期工具类
 * @author HQH
 *
 */
public class DateUtil {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		System.out.println("当天24点时间：" + getTimesnight().toLocaleString());
//		System.out.println("当前时间：" + new Date().toLocaleString());
//		System.out.println("当天0点时间：" + getTimesmorning().toLocaleString());
//		System.out.println("昨天0点时间：" + getYesterdaymorning().toLocaleString());
//		System.out.println("近7天时间：" + getWeekFromNow().toLocaleString());
//		System.out.println("本周周一0点时间：" + getTimesWeekmorning().toLocaleString());
//		System.out.println("本周周日24点时间：" + getTimesWeeknight().toLocaleString());
//		System.out.println("本月初0点时间：" + getTimesMonthmorning().toLocaleString());
//		System.out.println("本月未24点时间：" + getTimesMonthnight().toLocaleString());
//		System.out.println("上月初0点时间：" + getLastMonthStartMorning().toLocaleString());
//		System.out.println("本季度开始点时间：" + getCurrentQuarterStartTime().toLocaleString());
//		System.out.println("本季度结束点时间：" + getCurrentQuarterEndTime().toLocaleString());
//		System.out.println("本年开始点时间：" + getCurrentYearStartTime().toLocaleString());
//		System.out.println("本年结束点时间：" + getCurrentYearEndTime().toLocaleString());
//		System.out.println("上年开始点时间：" + getLastYearStartTime().toLocaleString());
//		System.out.println("下月末24点时间：" + getNextMonthEndNight().toLocaleString());
    }

    /**
     * 存放已经格式化的日期格式辅助类 主要是加快日期格式化的速度，减少日期格式化的对象创建
     */
    private static final Map<String, SimpleDateFormat> DATE_FORMATES = new HashMap<String, SimpleDateFormat>();

    /**
     * 获得给定日期凌晨00:00:00
     *
     * @param date
     * @return
     */
    public static Date getStartDate(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat date_sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = date_sdf.format(date);
        try {
            SimpleDateFormat time_sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return time_sdf.parse(formatDate + " 00:00:00");
        } catch (ParseException e) {
        }
        return null;
    }

    /**
     * 获得给定日期晚上23:59:59
     * @param date
     * @return
     */
    public static Date getEndDate(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat date_sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = date_sdf.format(date);
        try {
            SimpleDateFormat time_sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return time_sdf.parse(formatDate + " 23:59:59");
        } catch (ParseException e) {
        }
        return null;
    }

    /**
     * 获取<code>date<code>所在月份第一天
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, 1);
        Date theDate = calendar.getTime();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(df.format(theDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取<code>date<code>所在月份最后一天
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);     //设置为该月第一天
        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(df.format(calendar.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取偏移days前/后的日期
     * @param date 参照时间点
     * @param days 具体偏移天数(>0 往后 <0:往前)
     * @return
     */
    public static Date getOffsetDay(Date date,int days){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,days);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(df.format(calendar.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将指定日期转换为指定的日期格式的日期字符串
     *
     * @param date
     *            要标准化的日期
     * @param pattern
     *            日期格式，如yyyy-MM-dd HH:mm:ss
     * @return 标准化后的日期字符串
     */
    public static String date2String(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        return getDateFormat(pattern).format(date);
    }

    /**
     * 获取指定日期格式字符串的日期格式化辅助类
     *
     * @param pattern
     *            日期格式字符串
     * @return 日期格式化字符串
     */
    protected static SimpleDateFormat getDateFormat(String pattern) {
        if (pattern == null) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        synchronized (DATE_FORMATES) {
            if (DATE_FORMATES.containsKey(pattern)) {
                return DATE_FORMATES.get(pattern);
            } else {
                SimpleDateFormat dateFormate = new SimpleDateFormat(pattern);
                DATE_FORMATES.put(pattern, dateFormate);
                return dateFormate;
            }
        }
    }

    /**
     * 日期的月份加法运算
     *
     * @param date
     *            源日期
     * @param n
     *            运算月份数(支持负数)
     * @return 几月前或几月后日期
     */
    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    // 获得当天0点时间
    public static Date getTimesmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();


    }
    // 获得昨天0点时间
    public static Date getYesterdaymorning() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(getTimesmorning().getTime()-3600*24*1000);
        return cal.getTime();
    }

    // 获得当天近7天时间
    public static Date getWeekFromNow() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis( getTimesmorning().getTime()-3600*24*1000*7);
        return cal.getTime();
    }

    // 获得当天24点时间
    public static Date getTimesnight() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    // 获得本周一0点时间
    public static Date getTimesWeekmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    // 获得本周日24点时间
    public static Date getTimesWeeknight() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getTimesWeekmorning());
        cal.add(Calendar.DAY_OF_WEEK, 7);
        return cal.getTime();
    }

    // 获得本月第一天0点时间
    public static Date getTimesMonthmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    // 获得本月最后一天24点时间
    public static Date getTimesMonthnight() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        return cal.getTime();
    }

    // 获得上月第一天0点时间
    public static Date getLastMonthStartMorning() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getTimesMonthmorning());
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }
    // 获得下月最后一天24点时间
    public static Date getNextMonthEndNight() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        return cal.getTime();
    }

    public static Date getCurrentQuarterStartTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 4);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前季度的结束时间，即2012-03-31 23:59:59
     *
     * @return
     */
    public static Date getCurrentQuarterEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getCurrentQuarterStartTime());
        cal.add(Calendar.MONTH, 3);
        return cal.getTime();
    }


    public static Date getCurrentYearStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.YEAR));
        return cal.getTime();
    }

    public static Date getCurrentYearEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getCurrentYearStartTime());
        cal.add(Calendar.YEAR, 1);
        return cal.getTime();
    }

    public static Date getLastYearStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getCurrentYearStartTime());
        cal.add(Calendar.YEAR, -1);
        return cal.getTime();
    }

    /**
     * 计算两个日期之间相差的天数
     * @param start 较小的时间
     * @param end  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date start,Date end) throws ParseException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        start=sdf.parse(sdf.format(start));
        end=sdf.parse(sdf.format(end));
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        long time1 = cal.getTimeInMillis();
        cal.setTime(end);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 将指定日期字符串按照指定格式格式化为日期
     *
     * @param date
     *            字符串 日期字符串
     * @param pattern
     *            日期格式字符串
     * @return 格式化后的日期. 如果日期字符串为Null或无法格式化则返回Null
     */
    public static Date string2Date(String date, String pattern) {
        if (date == null) {
            return null;
        }
        try {
            return getDateFormat(pattern).parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
