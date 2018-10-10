package basic.otherAPI;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xjlin on 2018/9/11.
 */
public class DateDemo{
    /**
     * 演示Date
     */
    public static void main(String[] args){
        Date date = new Date();
        System.out.println(date); //Tue Sep 11 10:58:08 CST 2018

        //格式化日期DateFormat
        DateFormat dateFormat = DateFormat.getDateInstance();
        String str_date = dateFormat.format(date);
        System.out.println(str_date); //2018-9-11

        DateFormat dateFormat2 = DateFormat.getDateInstance(DateFormat.FULL); //2018年9月11日 星期二
        DateFormat dateFormat3 = DateFormat.getDateInstance(DateFormat.LONG); //2018年9月11日
        DateFormat dateFormat4 = DateFormat.getDateInstance(DateFormat.MEDIUM ); //2018-9-11
        DateFormat dateFormat5 = DateFormat.getDateInstance(DateFormat.SHORT); //18-9-11
        System.out.println(dateFormat2.format(date));
        System.out.println(dateFormat3.format(date));
        System.out.println(dateFormat4.format(date));
        System.out.println(dateFormat5.format(date));

        //日期+时间
        DateFormat dateFormat6 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
        DateFormat dateFormat7 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        DateFormat dateFormat8 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
        DateFormat dateFormat9 = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
        System.out.println(dateFormat6.format(date)); //2018年9月11日 星期二 上午11时08分52秒 CST
        System.out.println(dateFormat7.format(date)); //2018年9月11日 上午11时10分08秒
        System.out.println(dateFormat8.format(date)); //2018-9-11 11:10:08
        System.out.println(dateFormat9.format(date)); //18-9-11 上午11:10

        //自定义格式 // 1900年开始， month从0开始
        date = new Date(118,11,1);
        DateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy MM dd hh:mm:ss");
        DateFormat simpleDateFormat2 = new SimpleDateFormat("yy-M-d");
        DateFormat simpleDateFormat3 = new SimpleDateFormat("y-M-d");
        DateFormat simpleDateFormat4 = new SimpleDateFormat("y-d");
        DateFormat simpleDateFormat5 = new SimpleDateFormat("y-D"); //D代表年中的天数
        System.out.println(simpleDateFormat1.format(date));//2018 12 01 12:00:00
        System.out.println(simpleDateFormat2.format(date));//18-12-1
        System.out.println(simpleDateFormat3.format(date));//2018-12-1 //如果哪一位位数不足， 恢复默认（yyyy MM dd hh mm ss）
        System.out.println(simpleDateFormat4.format(date));//2018-1  //果然没有月份
        System.out.println(simpleDateFormat5.format(date));//2018-335

        //解析DateFormat.parse（默认格式， 一般不用）
        String dateStr1 = "2018 09 11"; //默认格式异常
        String dateStr2 = "2018/09/11"; //默认格式异常
        String dateStr3 = "2018-09-11"; //正常
        String dateStr4 = "2018年09月11日";//默认格式异常
        DateFormat dateFormat11 = DateFormat.getDateInstance();
        try{
//            System.out.println(dateFormat11.parse(dateStr1));
//            System.out.println(dateFormat11.parse(dateStr2));
            System.out.println(dateFormat11.parse(dateStr3));  //Tue Sep 11 00:00:00 CST 2018
//            System.out.println(dateFormat11.parse(dateStr4));
        }catch(ParseException e){
            e.printStackTrace();
        }

        //自定义格式解析
        String str_format = "yyyy MM dd";
        DateFormat simpleDateFormat11 = new SimpleDateFormat(str_format);
        try{
            System.out.println(simpleDateFormat11.parse(dateStr1)); //Tue Sep 11 00:00:00 CST 2018
        } catch(ParseException e){
            e.printStackTrace();
        }
    }

}
