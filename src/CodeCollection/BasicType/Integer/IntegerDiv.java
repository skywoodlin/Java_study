package CodeCollection.BasicType.Integer;

import java.text.DecimalFormat;

/**
 * Created by xjlin on 2017/8/29.
 * 两个integer相除返回STring型的百分比
 */
public class IntegerDiv {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 3;
        DecimalFormat decimalFormat = new DecimalFormat("#%");
        System.out.println(decimalFormat.format(a.floatValue() / b.floatValue()));
    }
}
