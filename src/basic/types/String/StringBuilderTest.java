package basic.types.String;

/**
 * Created by xjlin on 2017/6/23.
 */
public class StringBuilderTest {
    public static void main(String[] args) {

        StringBuilder str = new StringBuilder("2017");
        StringBuilder str2 = new StringBuilderTest().testStringBuilder(str);
        System.out.println(str2);
        System.out.println(str);
        System.out.println(str == str2);

        StringBuilder str3 = new StringBuilder("2017");
        StringBuilder str4 = new StringBuilder("2017");
        System.out.println(str3.equals(str4));
        System.out.println(str3.toString().equals(str4.toString()));

    }

    StringBuilder testStringBuilder(StringBuilder a) {
        a.append("-18");
        return a;
    }


}
