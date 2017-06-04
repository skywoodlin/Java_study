package basic.Numbers;

import java.text.DecimalFormat;

/**
 * Decimal转字符串， 字符串转decimal
 * Created by xjlin on 2017/5/22.
 */
public class DecimalFormatTest {
    public static void main(String[] args) {
        DecimalFormat df1 = new DecimalFormat("0.0");
        DecimalFormat df2 = new DecimalFormat("#.#");
        DecimalFormat df3 = new DecimalFormat("000.000");
        DecimalFormat df4 = new DecimalFormat("###.###");
        System.out.println(df1.format(12.34));
        System.out.println(df2.format(12.34));
        System.out.println(df3.format(12.34));
        System.out.println(df4.format(12.34));

        DecimalFormat format = new DecimalFormat("###,####.000");
        System.out.println(format.format(111111123456.1227222));

//        Locale.setDefault(Locale.US);
        DecimalFormat usFormat = new DecimalFormat("###,###.000");
        System.out.println(usFormat.format(111111123456.1227222));

        DecimalFormat addPattenFormat = new DecimalFormat();
        addPattenFormat.applyPattern("##,###.000");
        System.out.println(addPattenFormat.format(111111123456.1227));

        DecimalFormat zhiFormat = new DecimalFormat();
        zhiFormat.applyPattern("0.000E0000");
        System.out.println(zhiFormat.format(10000));
        System.out.println(zhiFormat.format(12345678.345));

        DecimalFormat percentFormat = new DecimalFormat();
        percentFormat.applyPattern("#0.000%");
        System.out.println(percentFormat.format(0.3052222));




    }
}
