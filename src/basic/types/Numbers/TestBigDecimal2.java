package basic.types.Numbers;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * Created by xjlin on 2017/12/13.
 */
public class TestBigDecimal2 {
    public static void main(String[] args) {
        try {
            final Pattern NUM_PATTERN = Pattern.compile("^-?[0-9]+(\\.[0-9]+)?$|[+-][1-9]\".\"[0-9]+E[+-][0-9]+");
            String valStr = "3e-3";
            if(!NUM_PATTERN.matcher(valStr).find()) {
                System.out.println("不是科学计数法");
            }

            BigDecimal a = new BigDecimal("3se-3");

            System.out.println(a.add(BigDecimal.ONE));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
