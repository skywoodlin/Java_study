package basic.Numbers;

/**
 * Created by xjlin on 2017/8/14.
 */
public class ParseIntTest {
    public static void main(String[] args) {
        int a = Integer.parseInt("032");
        System.out.println(a);
        int b = Integer.parseInt("a32");//报错
//        System.out.println(b);
    }
}
