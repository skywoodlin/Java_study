package basic.String;

import java.util.regex.Pattern;

/**
 * Created by xjlin on 2017/10/13.
 */
public class ContainsTest {
    public static void main(String[] args) {
        /*String a = "商超小票款/楦号";
        String b = "/号";

        if(a.contains(b)) {
            System.out.println("");
        }*/
        final Pattern NUM_PATTERN = Pattern.compile("^-?[0-9]+(\\.[0-9]+)?$|[+-][1-9]\".\"[0-9]+E[+-][0-9]+");
        System.out.println("顺丰".toUpperCase());
    }
}
