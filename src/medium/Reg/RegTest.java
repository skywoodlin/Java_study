package medium.Reg;

import java.util.regex.Pattern;

/**
 * Created by xjlin on 2017/9/26.
 */
public class RegTest {
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[\\d]{4}[-][0|1]?[\\d]{1}[-][0-3]?[\\d]{1}$");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {
//        System.out.println(RegTest.isInteger("2017-08-01"));
//        System.out.println("2017-07-08".substring(8,10));
        int a = "2017-09".compareTo("2017-09");
        System.out.println(a);
        if (a < 0) {
            System.out.println("old");
        }else {
            System.out.println("new");
        }
    }
}
