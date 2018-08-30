package basic.Numbers;

import java.math.BigDecimal;

/**
 * Created by xjlin on 2017/7/4.
 */
public class BigDecimalCalc {
    public static void main(String[] args) {
//        BigDecimal a = new BigDecimal(1.3);
//        System.out.println(a.add(new BigDecimal(3.3)));
//        System.out.println(a);

        //保留两位小数(注意， 这个setScale不会改变本身)
        BigDecimal b = new BigDecimal(1.3738);
        System.out.println(b);
        System.out.println(b.setScale(2,BigDecimal.ROUND_HALF_UP).toString());
        System.out.println(b);

        System.out.println(b.setScale(1,BigDecimal.ROUND_HALF_UP) == b);



    }

}
