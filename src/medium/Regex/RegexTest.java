package medium.Regex;

import java.util.regex.Pattern;

/**
 * Created by xjlin on 2017/9/26.
 */
public class RegexTest{
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[\\d]{4}[-][0|1]?[\\d]{1}[-][0-3]?[\\d]{1}$");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {
//        System.out.println(RegexTest.isInteger("2017-08-01"));
        int a = "2017-09".compareTo("2017-09");
        System.out.println(a);
        if (a < 0) {
            System.out.println("old");
        }else {
            System.out.println("new");
        }
    }
}
