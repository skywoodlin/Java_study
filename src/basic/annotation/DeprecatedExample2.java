package basic.annotation;

/**
 * Created by xjlin on 2019/1/30.
 */

public class DeprecatedExample2 {
    @Deprecated
    public static void foo() {
        System.out.println("haha");
    }
}


class DeprecatedUser2{
//    @SuppressWarnings(value = {"deprecation"})
    public static void main(String[] args){
        DeprecatedExample2.foo();
    }
}