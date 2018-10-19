package basic.types.String;

/**
 * Created by xjlin on 2017/6/23.
 */
public class CompareToTest {
    public static void main(String[] args) {
        String a = "2017-07";
        String b = "2017-08";
        String c = "2017-07";
        String d = "2017-06";

        System.out.println(a.compareTo(b));
        System.out.println(a.compareTo(c));
        System.out.println(a.compareTo(d));

    }
}
