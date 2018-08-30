package medium.GenericMethod;
/**
 * 注意： 调用每个参数必须一样类型。
 */

import forWork.Test2.Test;

/**
 * Created by xjlin on 2017/12/14.
 */
public class ArrayAlg {
    public static void main(String[] args) {
//        String middle = ArrayAlg.getMiddle(3.14, 1729, 0); //编译错误
        double middle = ArrayAlg.getMiddle(3.14, 17.29, 0.0);
        System.out.println(middle);


        String a = "a1";
        String b = "b1";
        String result = ArrayAlg.min(a,b);
        System.out.println(result);

        int i1 = 1;
        int i2 = 2;
        int result2 = ArrayAlg.min(i1, i2);
        System.out.println(result2);
    }



    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    public static<T extends Comparable> T min(T... a) {
        if(a == null || a.length == 0) {
            return null;
        }
        T smallest = a[0];
        for(int i = 1; i < a.length; i++) {
            if(smallest.compareTo(a[i]) > 0 ) {
                smallest = a[i];
            }
        }
        System.out.println(smallest instanceof Integer);
        return  smallest;
    }
}
