package basic.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xjlin on 2017/5/22.
 * 字符串转Date用parse（String）， Date转字符串用format
 * 注意： 例如年（yyyy）， 你可以只写一个y, 写“yy”输出字符串的时候会省略前面的“20”（如2017年只显示17年）， 其它同理
 *
 时间日期标识符：
     yyyy：年
     MM：月
     dd：日
     hh：1~12小时制(1-12)
     HH：24小时制(0-23)
     mm：分
     ss：秒
     S：毫秒
     E：星期几
     D：一年中的第几天
     F：一月中的第几个星期(会把这个月总共过的天数除以7)
     w：一年中的第几个星期
     W：一月中的第几星期(会根据实际情况来算)
     a：上下午标识
     k：和HH差不多，表示一天24小时制(1-24)。
     K：和hh<span style="font-family: Arial, Helvetica, sans-serif;">差不多</span><span style="font-family: Arial, Helvetica, sans-serif;">，表示一天12小时制(0-11)。</span>
     z：表示时区
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        Date d1 = new Date();
        System.out.println(sdf.format(d1));


        String d2Str = "2017年03月03日 12时12分12秒";
        Date d2 = null;
        try{
            d2 = sdf.parse(d2Str);
        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(d2);

        //集大成的例子
        sdf = new SimpleDateFormat("yyyyyyyy-MM-dd HH(hh):mm:ss S E D F w W a k K z");
        long times = System.currentTimeMillis();
        System.out.println(times);
        Date date = new Date(times);
        String tim = sdf.format(date);
        System.out.println(tim);

    }
}
