package medium.GenericClass;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by xjlin on 2017/12/14.
 */
public class PairTest2 {
    public static void main(String[] args) {
        GregorianCalendar[] birthdays = {
                new GregorianCalendar(1906, Calendar.DECEMBER, 9),
                new GregorianCalendar(1907, Calendar.DECEMBER, 9),
                new GregorianCalendar(1908, Calendar.DECEMBER, 9),
                new GregorianCalendar(1909, Calendar.DECEMBER, 9),
        };

        Pair<GregorianCalendar> mm = ArrayAlg2.minmax(birthdays);
        System.out.println("min = " + mm.getFirst().getTime());
        System.out.println("max = " + mm.getSecond().getTime());

        TestClass[] a = {new TestClass(), new TestClass(), new TestClass(), new TestClass()};
//        Pair<TestClass> test = ArrayAlg2.minmax(a);  //编译不过， TestClass必须实现compareto
    }
}

class ArrayAlg2 {
    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if(a == null || a.length == 0) {
            return null;
        }
        T min = a[0];
        T max = a[0];
        for(int i = 1; i < a.length ; i ++) {
            if(min.compareTo(a[i]) > 0) min = a[i];
            if(max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min,max);
    }
}

class TestClass {

}

