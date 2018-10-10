package basic.otherAPI;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by xjlin on 2018/9/11.
 */
public class DateDemo2{
    public static void main(String[] args){

        //毫秒值转日期
        long time = System.currentTimeMillis();
        System.out.println(time); //1536636833008
        Date date = new Date(time);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println(dateFormat.format(date));

        //日期转毫秒值
        long time2 = new Date().getTime();
        System.out.println(time2);
    }
}
