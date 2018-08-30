package basic.Date;


import java.util.Date;

/**
 * Created by xjlin on 2018/3/27.
 */
public class DataFormat {
    public static void main(String[] args) {
        String  a = String.format("%04d", new java.util
                .Random()
                .nextInt(9999));
        System.out.println(a);
    }
}
