package utils;

/**
 * Created by xjlin on 2017/6/4.
 */
import framework.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <p>
 * com.cs.common.util.DateUtils
 * </p>
 * Function List:<br>
 * 常用的时间操作
 *
 */
public class DateUtils extends DateUtil {

    /** ********** begin 不推荐写法 */
    /**
     * 不再推荐使用;推荐使用 DateUtils.yyyyMMdd_HH_mm_ss
     */
    @Deprecated
    public static final String DATEFORMATLONG17 = "yyyyMMdd HH:mm:ss";

    /**
     * 不再推荐使用;推荐使用 DateUtils.yyyyMMdd_HH_mm_ss_SS
     */
    @Deprecated
    public static final String DATEFORMATLONG20 = "yyyyMMdd HH:mm:ss:SS";

    /**
     * 不再推荐使用;推荐使用 DateUtils.yyyy_MM_dd_HH_mm_ss
     */
    @Deprecated
    public static final String DATEFORMATLONG = "yyyy-MM-dd HH:mm:ss";

    /**
     * 不再推荐使用;推荐使用 DateUtils.yyyy_MM_dd_HH_mm
     */
    @Deprecated
    public static final String DATEFORMATMEDIUM = "yyyy-MM-dd HH:mm";

    /**
     * 不再推荐使用;推荐使用 DateUtils.yyyyMMddHH
     */
    @Deprecated
    public static final String DATE_FORMAT_YMDH = "yyyyMMddHH";

    /**
     * 不再推荐使用;推荐使用 DateUtils.yyyy_MM_dd
     */
    @Deprecated
    public static final String DATEFORMATSHORT = "yyyy-MM-dd";

    /**
     * 不再推荐使用;推荐使用 DateUtils.yyyy_MM
     */
    @Deprecated
    public static final String DATE_SHORT_YEARMONTH = "yyyy-MM";

    /**
     * 不再推荐使用;推荐使用 DateUtils.yyyyMMdd
     */
    @Deprecated
    public static final String DATENUMBERFORMAT = "yyyyMMdd";

    /**
     * 不再推荐使用;推荐使用 DateUtils.yyyyMMddHH
     */
    @Deprecated
    public static final String DATEHOURNUMBERFORMAT = "yyyyMMddHH";

    /**
     * 不再推荐使用;推荐使用 DateUtils.H
     */
    @Deprecated
    public static final String DATE_FORMAT_HOUR = "H";

    /** ********** end 不推荐写法 */

    /**
     * 格式 yyyyMMdd HH:mm:ss
     */
    public static final String yyyyMMdd_HH_mm_ss = "yyyyMMdd HH:mm:ss";

    /**
     * 格式 yyyyMMdd HH:mm:ss:SS
     */
    public static final String yyyyMMdd_HH_mm_ss_SS = "yyyyMMdd HH:mm:ss:SS";

    /**
     * 格式 yyyy-MM-dd HH:mm
     */
    public static final String yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";

    /**
     * 格式  yyyy-MM
     */
    public static final String yyyy_MM = "yyyy-MM";

    /**
     * 格式  yyyyMMdd
     */
    public static final String yyyyMMdd = "yyyyMMdd";

    /**
     * 格式  yyyyMMddHH
     */
    public static final String yyyyMMddHH = "yyyyMMddHH";

    /**
     * 格式 H
     */
    public static final String H = "H";

    private static Date dateInstance;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    /**
     * 获取当前日期
     *
     * @return
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * 获得系统的当前时间,毫秒.
     *
     * @return
     */
    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前年月日
     *
     * @return String YYYY-MM
     */
    public static String getCurrentYearMonthDate() {
        return getCurrentFormatDate(DATE_SHORT_YEARMONTH);
    }

    /**
     * 计算两个日期之间的差距天数
     *
     * @param a
     * @param b
     * @return
     */
    public static int cutTwoDateToDay(Date a, Date b) {
        SimpleDateFormat format = new SimpleDateFormat(yyyy_MM_dd);
        Calendar calendar = Calendar.getInstance();
        int theday = 0;
        try {
            Date beginDate = format.parse(format.format(a));
            Date endDate = format.parse(format.format(b));

            calendar.setTime(beginDate);
            long begin = calendar.getTimeInMillis();
            calendar.setTime(endDate);
            long end = calendar.getTimeInMillis();

            theday = (int) ((end - begin) / (86400000));
        } catch (ParseException e) {
            logger.debug("日期转换出错!", e);
        }
        return theday;
    }

    /**
     * 将数字型的时间转为字符串（80 -> 01:20）
     *
     * @param time
     * @return
     */
    public static String intToTimeString(int time) {
        String hour = String.valueOf(time / 60);
        String minute = String.valueOf(time - time / 60 * 60);

        if (hour.length() < 2) {
            hour = "0" + hour;
        }
        if (minute.length() < 2) {
            minute = "0" + minute;
        }
        return hour + ":" + minute;
    }

    /**
     * 取出两个时间出较大的时间
     *
     * @param data1
     * @param data2
     * @return
     */
    public static Date maxDate(Date data1, Date data2) {
        if (data1.before(data2)) {
            return data2;
        } else {
            return data1;
        }
    }

    /**
     * 取出两个时间出较小的时间
     *
     * @param a
     * @param b
     * @return
     */
    public static Date minDate(Date a, Date b) {
        if (a.before(b)) {
            return a;
        } else {
            return b;
        }
    }

    /**
     * 计算给定日期是星期几
     *
     * @param date
     * @return
     */
    public static int getWeekOfDate(Date date) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(java.util.Calendar.DAY_OF_WEEK) - 1;
        if (w == 0) {
            w = 7;
        }
        return w;
    }

    /**
     * 计算星期
     *
     * @return
     */
    public static int getDayOfWeek() {
        int dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

        if (dayOfWeek == 1) {
            dayOfWeek = 7;
        } else {
            dayOfWeek -= 1;
        }
        return dayOfWeek;
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 根据给定日期字符串和日期格式 创建日期
     *
     * @param dateString
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date createDate(String dateString, String pattern) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.parse(dateString);
    }

    /**
     * 根据给定格式取得当前日期
     *
     * @param formatDate
     * @return
     */
    public static synchronized String getCurrentFormatDate(String formatDate) {
        dateInstance = getCurrentDate();
        simpleDateFormat.applyPattern(formatDate);
        return simpleDateFormat.format(dateInstance);
    }

    /**
     * 获取当前日期 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getCurrentFormatDateLong() {
        return getCurrentFormatDate(DATEFORMATLONG);
    }

    /**
     * 获取当前日期 yyyyMMdd HH:mm:ss
     * @return
     */
    public static String getCurrentFormatDateLong17() {
        return getCurrentFormatDate(DATEFORMATLONG17);
    }

    /**
     * 获取当前日期 yyyyMMdd HH:mm:ss
     * @return
     */
    public static String getCurrentFormatDateLong20() {
        return getCurrentFormatDate(DATEFORMATLONG20);
    }

    /**
     * 获取当前日期 yyyy-MM-dd HH:mm
     *
     * @return
     */
    public static String getCurrentFormatDateMedium() {
        return getCurrentFormatDate(DATEFORMATMEDIUM);
    }

    /**
     * 获取当前日期 "yyyy-MM-dd"
     *
     * @return
     */
    public static String getCurrentFormatDateShort() {
        return getCurrentFormatDate(DATEFORMATSHORT);
    }

    /**
     * 将date类型转换为string
     * @param format
     * @param date
     * @return
     */
    private static synchronized String getDate2String(String format, Date date) {
        simpleDateFormat.applyPattern(format);
        return simpleDateFormat.format(date);
    }

    /**
     * 日期转换为字符串 格式为"yyyy-MM-dd HH:mm:ss";
     *
     * @param date
     * @return
     */
    public static String getDate2LongString(Date date) {
        return getDate2String(DATEFORMATLONG, date);
    }

    /**
     * 日期转换为字符串 格式为"yyyyMMdd HH:mm:ss";
     *
     * @param date
     * @return
     */
    public static String getDate2LongString17(Date date) {
        return getDate2String(DATEFORMATLONG17, date);
    }

    /**
     * 日期转换为字符串 格式为"yyyy-MM-dd HH:mm";
     *
     * @param date
     * @return
     */
    public static String getDate2MediumString(Date date) {
        return getDate2String(DATEFORMATMEDIUM, date);
    }

    /**
     * 日期转换为字符串 格式为"yyyy-MM-dd";
     *
     * @param date
     * @return
     */
    public static String getDate2ShortString(Date date) {
        return getDate2String(DATEFORMATSHORT, date);
    }

    /**
     * 日期转换为字符串 格式为"H";
     *
     * @param date
     * @return
     */
    public static String getDate2HourString(Date date) {
        return getDate2String(DATE_FORMAT_HOUR, date);
    }

    /**
     * 日期转换为字符串 格式为"yyyyMMdd";
     *
     * @param date
     * @return
     */
    public static String getDate2NumberString(Date date) {
        return getDate2String(DATENUMBERFORMAT, date);
    }

    /**
     * 将long型的日期数据转换为string 格式为"yyyy-MM-dd HH:mm:ss";
     *
     * @param l
     * @return
     */
    public static String getLong2LongString(long l) {
        dateInstance = getLong2Date(l);
        return getDate2LongString(dateInstance);
    }

    /**
     * 将long型的日期数据转换为string 格式为"yyyy-MM-dd HH:mm";
     *
     * @param l
     * @return
     */
    public static String getLong2MediumString(long l) {
        dateInstance = getLong2Date(l);
        return getDate2MediumString(dateInstance);
    }

    /**
     * 将long型的日期数据转换为string 格式为"yyyy-MM-dd";
     *
     * @param l
     * @return
     */
    public static String getLong2ShortString(long l) {
        dateInstance = getLong2Date(l);
        return getDate2ShortString(dateInstance);
    }

    /**
     * 根据传日的格式和日期字符串获取日期类型数据
     *
     * @param format
     * @param str
     * @return
     */
    private static synchronized Date getString2Date(String format, String str) {
        simpleDateFormat.applyPattern(format);
        ParsePosition parseposition = new ParsePosition(0);
        return simpleDateFormat.parse(str, parseposition);
    }

    /**
     * 根据传入的字符串获取日期类型数据 格式为格式为"yyyy-MM-dd HH:mm:ss";
     *
     * @param str
     * @return
     */
    public static Date getString2LongDate(String str) {
        return getString2Date(DATEFORMATLONG, str);
    }

    /**
     * 根据传入的字符串获取日期类型数据 格式为格式为"yyyyMMdd HH:mm:ss";
     *
     * @param str
     * @return
     */
    public static Date getString2LongDate17(String str) {
        return getString2Date(DATEFORMATLONG17, str);
    }

    /**
     * 根据传入的字符串获取日期类型数据 格式为格式为"yyyyMMdd HH:mm:ss:SS";
     *
     * @param str
     * @return
     */
    public static Date getString2LongDate20(String str) {
        return getString2Date(DATEFORMATLONG20, str);
    }

    /**
     * 根据传入的字符串获取日期类型数据 格式为格式为"yyyy-MM-dd HH:mm";
     *
     * @param str
     * @return
     */
    public static Date getString2MediumDate(String str) {
        return getString2Date(DATEFORMATMEDIUM, str);
    }

    /**
     * 根据传入的字符串获取日期类型数据 格式为格式为"yyyyMMddHH";
     *
     * @param str
     * @return
     */
    public static Date getString2YmdhDate(String str) {
        return getString2Date(DATE_FORMAT_YMDH, str);
    }

    /**
     * 根据传入的字符串获取日期类型数据 格式为格式为"yyyy-MM-dd";
     *
     * @param str
     * @return
     */
    public static Date getString2ShortDate(String str) {
        return getString2Date(DATEFORMATSHORT, str);
    }

    /**
     * 获取空日期 默认为1971-01-01
     *
     * @return
     */
    public static Date getEmptyDate() {
        return getString2ShortDate("1971-01-01");
    }

    /**
     * 空日期字符串
     *
     * @return
     */
    public static String getEmptyDateString() {
        return "1971-01-01";
    }

    /**
     * 根据long型日期获取日期类型
     */
    public static Date getLong2Date(long l) {
        return new Date(l);
    }

    /**
     *
     * @param l
     * @return
     */
    public static int getOffMinutes(long l) {
        return getOffMinutes(l, getCurrentTimeMillis());
    }

    /**
     *
     * @param from
     * @param to
     * @return
     */
    public static int getOffMinutes(long from, long to) {
        return (int) ((to - from) / 60000L);
    }

    /**
     * 获取年
     */
    public static int getYear() {
        return Calendar.getInstance().get(1);
    }

    /**
     * 获取月
     *
     * @return
     */
    public static int getMonth() {
        return Calendar.getInstance().get(2) + 1;
    }

    public static int getDay() {
        return Calendar.getInstance().get(5);
    }

    public static int getHour() {
        return Calendar.getInstance().get(11);
    }

    public static int getMinute() {
        return Calendar.getInstance().get(12);
    }

    public static int getSecond() {
        return Calendar.getInstance().get(13);
    }

    /**
     *
     * @param day
     * @return
     */
    public static String add(int day) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(GregorianCalendar.DATE, day);
        dateInstance = gregorianCalendar.getTime();
        return getDate2String(DATEFORMATSHORT, dateInstance);

    }

    /**
     *
     * @param day
     * @return
     */
    public static String subtract(int day) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(GregorianCalendar.DATE, -day);
        dateInstance = gregorianCalendar.getTime();
        return getDate2String(DATEFORMATSHORT, dateInstance);

    }

    /**
     *
     * @return
     */
    public static String getlastMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        GregorianCalendar gc = new GregorianCalendar();
        gc.roll(Calendar.MONTH, false);
        return sdf.format(gc.getTime());
    }

    /**
     *
     * @return
     */
    public static String getCurrentLastMonth() {
        SimpleDateFormat format = new SimpleDateFormat(yyyy_MM);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        return format.format(cal.getTime());
    }

    /**
     * @return String[]
     *
     */
    public static String[] getCurrentLastWeek() {
        String[] weeks = new String[2];
        SimpleDateFormat format = new SimpleDateFormat(yyyy_MM_dd);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -cal.get(Calendar.DAY_OF_WEEK));
        weeks[1] = format.format(cal.getTime());
        cal.add(Calendar.DAY_OF_YEAR, -6);
        weeks[0] = format.format(cal.getTime());
        return weeks;
    }

    /**
     * if(?1?7始日?1?7结束日期)，return TURE;else return FALSE;
     *
     * @return
     */
    public static boolean isStartLessEndTime(String start, String end) throws ParseException {
        if (start.equals("") || end.equals("")) {
            return false;
        }
        Date startDate = DateFormat.getDateInstance().parse(start);
        Date endDate = DateFormat.getDateInstance().parse(end);
        return startDate.compareTo(endDate) < 0;
    }

    /**
     * 获取今日
     *
     * @return
     */
    public static Date getToday() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }

    /**
     *
     * @return
     */
    public static Date getYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 返回当前周第一天
     *
     * @return Date
     * @see Date
     */
    public static Date getFirstDayOfThisWeek() {
        Date today = getToday();
        return getFirstDayInWeek(today);
    }

    /**
     * 获取指定的第一天
     * @return
     */
    public static Date getFirstDayInMonth(int year, int month) {
        month--; // Calendar month is base on 0; 0 is January
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month, 1);
        return cal.getTime();
    }

    /**
     * 获取指定月的最后一天
     * @return
     */
    public static Date getLastDayInMonth(int year, int month) {
        Date firstDay = getFirstDayInMonth(year, month);
        Calendar firstCal = getCalendarByDate(firstDay);
        firstCal.add(Calendar.MONTH, 1); // forward one month
        firstCal.add(Calendar.DAY_OF_YEAR, -1); // back one day
        return firstCal.getTime();
    }

    /**
     * 获取当前月的第一天
     * @return
     */
    public static Date getFirstDayOfThisMonth() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month++;
        return getFirstDayInMonth(year, month);
    }

    /**
     * 获取上个月的第一天
     * @return
     */
    public static Date getFirstDayOfLastMonth() {
        int year = getYearOfLastMonth();
        int month = getMonthOfLastMonth();
        return getFirstDayInMonth(year, month);
    }

    /**
     *
     * @return
     */
    private static int getYearOfLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取上个月的月份
     * @return
     */
    private static int getMonthOfLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        int month = cal.get(Calendar.MONTH);
        month++;
        return month;
    }

    /**
     * 获取当前月
     * @return
     */
    public static int getThisMonth() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
        month++;
        return month;
    }

    /**
     * 获取指定年的第一天
     * @return
     */
    public static Date getFirstDayInYear(int year) {
        int month = 0;
        int day = 1;
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        return cal.getTime();
    }

    /**
     * 获取指定年的最后一天的日期
     * @return
     */
    public static Date getLastDayInYear(int year) {
        int month = 11;
        int day = 31;
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        return cal.getTime();
    }

    /**
     * 获取当前年
     * @return
     */
    public static int getThisYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取去年的int数据
     * @return
     */
    public static int getLastYear() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -1);
        return cal.get(Calendar.YEAR);
    }

    /**
     * return first day in week by date
     * @param date
     * @return
     */
    public static Date getFirstDayInWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int thisweek = cal.get(Calendar.WEEK_OF_YEAR);
        int lastweek = thisweek;
        Date thisday = null;
        while (lastweek == thisweek) {
            thisday = cal.getTime();
            cal.add(Calendar.DAY_OF_MONTH, -1); // back one day
            lastweek = cal.get(Calendar.WEEK_OF_YEAR);
        }
        return thisday;
    }

    /**
     * return last day in week by date
     * @param date
     * @return
     */
    public static Date getLastDayInWeek(Date date) {
        Date firstdayofweek = getFirstDayInWeek(date);
        Calendar cal = getCalendarByDate(firstdayofweek);
        cal.add(Calendar.DAY_OF_YEAR, 6);
        return cal.getTime();
    }

    /**
     * 根据给定的日期获取年份
     * @return
     */
    private static Calendar getCalendarByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    /**
     *
     * @return
     */
    public static String getDateStr(Date date) {
        String pattern = yyyy_MM_dd; // should be locale
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     *
     * @return
     */
    public static String getMonthStr(Date date) {
        String pattern = yyyy_MM; // should be locale
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     *
     * @return
     */
    public static Date getDateByStr(String dateStr) {
        String pattern = yyyy_MM_dd; // should be locale
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("wrong date format, should be " + pattern);
        }
        return date;
    }

    /**
     *
     * @return
     */
    public static String addHour(int hour) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(GregorianCalendar.HOUR, hour);
        dateInstance = gregorianCalendar.getTime();
        return getDate2String(DATEHOURNUMBERFORMAT, dateInstance);

    }

    /**
     *
     * @param hour
     * @return
     */
    public static Date addHour2Date(int hour) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(GregorianCalendar.HOUR, hour);
        dateInstance = gregorianCalendar.getTime();
        return dateInstance;

    }

    /**
     *
     * @param hour
     * @return
     */
    public static String addHourReturnShortDate(int hour) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(GregorianCalendar.HOUR, hour);
        dateInstance = gregorianCalendar.getTime();
        return getDate2String(DATEFORMATSHORT, dateInstance);

    }

    /**
     * 获得下一小时
     *
     * @param hour
     * @return
     */
    public static Date getNextHourDate(int hour) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(GregorianCalendar.HOUR, hour);
        dateInstance = gregorianCalendar.getTime();
        String longDateTime = getDate2LongString(dateInstance);
        String NextDateHour = longDateTime.subSequence(0, 14) + "00:00";
        return getString2LongDate(NextDateHour);
    }

    /**
     * 获取下一分钟
     *
     * @param minute
     * @return
     */
    public static Date getNextMinuteDate(int minute) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(GregorianCalendar.MINUTE, minute);
        dateInstance = gregorianCalendar.getTime();
        String longDateTime = getDate2LongString(dateInstance);
        String NextDateMinute = longDateTime.subSequence(0, 17) + "00";
        return getString2LongDate(NextDateMinute);
    }

    /**
     * 计算给定日期是否在日期范围内
     *
     * @param startDate
     * @param endDate
     * @param date
     * @return
     */
    public static boolean inDateRange(Date startDate, Date endDate, Date date) {

        if (startDate == null || endDate == null || date == null) {
            return false;
        }
        // 是否 startDate<=date<=endDate
        return (startDate.before(date) || startDate.equals(date)) && (endDate.after(date) || endDate.equals(date));
    }
}
