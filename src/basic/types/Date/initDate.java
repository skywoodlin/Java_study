package basic.types.Date;

import java.util.Date;

/**
 * Date类型初始化总结：（最好不用， 用新的方法： Calendar）
 * 1. 用不带参数new Date()获取当前时间
 * 2. new Date(1290876532190L);  //用于转换从数据库中拿出来的值： 时间戳是从1970年到现在的毫秒数
 * Created by xjlin on 2017/5/19.
 */
public class initDate {
    public static void main(String[] args) {
        //老方法， 过时
        Date date = new Date(2000, 3, 31);
        System.out.println(date);   // Tue May 01 00:00:00 CST 3900  不用了

        //错误的构造
//        Date date1 = new Date("2000-01-08");  //通不过编译
//        System.out.println(date1);
        //正确的构造
        Date d2 = new Date();  //获取当前时间
        System.out.println(d2);

        Date d3 = new Date(1290876532190L);
        System.out.println(d3);
    }
}
