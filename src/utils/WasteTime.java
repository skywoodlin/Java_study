package utils;

import java.util.Date;

/**
 * Created by xjlin on 2019/1/17.
 */
public class WasteTime{
    /**
     *  消耗大约(millsecond + 1)ms时间
     */
    public static void wasteTime(long millsecond){
        Long time1 = DateUtils.getCurrentTimeMillis();
        String s = "";
        Date d2 = new Date();
        while(DateUtils.getCurrentTimeMillis() - time1 <= millsecond){
            s = time1.toString(); //消耗时间
        }
//        Long time2 = DateUtils.getCurrentTimeMillis();
//        System.out.println(time2-time1);
    }
}
