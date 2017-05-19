package basic.trick;

/**
 * Created by xjlin on 2017/3/15.
 */

/**
 * 被动使用类字段演示三：
 * <p>
 * 常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，
 * 因此不会触发定义常量的类的初始化。
 **/
class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world";
}

public class InitialOrderTest_NoInitialTest2 {
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}


