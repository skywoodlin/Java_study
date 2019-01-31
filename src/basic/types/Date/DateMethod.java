package basic.types.Date;

import java.util.Date;

/**
 * Created by xjlin on 2017/5/19.
 */
public class DateMethod {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Date now = new Date();

        //都是过时的
        int year = now.getYear();       //117: 2017-1900从1900开始算  （从1900开始）
        int month = now .getMonth();   // 4： 5-1（当前是5月份）  从0开始
        int day = now.getDay();        // 5： 今天周五没错  从1开始
        int nowDate = now.getDate();   // 19： 19号也没错  从1开始
        int hour = now.getHours();     //从1开始
        int minute = now.getMinutes(); //从1开始
        int sec = now.getSeconds();    //从1开始

        System.out.println("" + year +" "+ month + " "+day + " "+nowDate+ " " + hour+ " " + minute+ " " + sec);

        long time = now.getTime();
        System.out.println("Milliseconds since Jan. 1, 1970 GMT = " + time);

        // 比较
        Date d1 = new Date(99, 2, 16);
        Date d2 = new Date(99, 2, 18);
        System.out.println(d1.before(d2)); // true;
        System.out.println(d1.after(d2)); //false
        System.out.println(d1.equals(d2));// false
        System.out.println(d1.compareTo(d2)); //  -1
        System.out.println(d2.compareTo(d1)); // 1

        Date d3 = (Date) d1.clone();
        Object d4 = d1.clone();
        Date d5 = (Date )d4;
        System.out.println(d3.equals(d1));  // true
        System.out.println(d5.compareTo(d3));  //0
    }


}
