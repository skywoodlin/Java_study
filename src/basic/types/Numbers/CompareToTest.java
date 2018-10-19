package basic.types.Numbers;

import java.math.BigDecimal;

/**
 * Created by xjlin on 2017/12/13.
 */
public class CompareToTest {
    public static void main(String[] args) {
        try {
            BigDecimal a = new BigDecimal(3);
            BigDecimal b = new BigDecimal(2);
            System.out.println(a.compareTo(b));

            BigDecimal c = a;
            System.out.println(c);

            a = BigDecimal.ONE;
            System.out.println(c);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
