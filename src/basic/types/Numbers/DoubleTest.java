package basic.types.Numbers;

import basic.importPackage.StaticImportDemo;

import java.math.BigDecimal;

/**
 * Created by xjlin on 2017/7/4.
 */
public class DoubleTest{
    static Double roundHalfUp_2Scale(Double b){
        if(b == null){
            return null;
        }
        BigDecimal d = new BigDecimal(b);
        return d.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    public static void main(String[] args){
        Double d1 = 114.145;
        Double d2 = -114.1;
        Double d3 = -114.0;
        Double d4 = null;
        Double d5 = 11.0;

        System.out.println(DoubleTest.roundHalfUp_2Scale(d1));
        System.out.println(DoubleTest.roundHalfUp_2Scale(d2));
        System.out.println(DoubleTest.roundHalfUp_2Scale(d3));
        System.out.println(DoubleTest.roundHalfUp_2Scale(d4));
        System.out.println(DoubleTest.roundHalfUp_2Scale(d5));
    }

}
