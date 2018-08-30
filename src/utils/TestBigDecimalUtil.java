package utils;

import java.math.BigDecimal;

/**
 * Created by xjlin on 2017/12/15.
 */
public class TestBigDecimalUtil{
    public static void main(String[] args) {
        try {
            BigDecimalUtils.parseBigDecimal("  ");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        BigDecimal a = new BigDecimal("1787.88");
        BigDecimal b = new BigDecimal("120000.88");
        BigDecimal taxRate = BigDecimalUtils.divide4(a, b);
        double c = taxRate.doubleValue();
        double d = c * 100;
        System.out.println(String.valueOf(d) + "%;");
    }
}
