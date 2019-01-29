package medium.Regex;

import java.util.regex.Pattern;

/**
 * Created by xjlin on 2017/9/26.
 */
public class RegexTest3{
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[\\d]{4}[-][0|1]?[\\d]{1}[-][0-3]?[\\d]{1}$");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {
        String s = "2010-12-20-";
        Pattern pattern = Pattern.compile("-");
        for(String part: pattern.split(s)) {
            System.out.println(part);
        }
    }
}
