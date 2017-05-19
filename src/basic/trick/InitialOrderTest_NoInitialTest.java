package basic.trick;

/**
 * Created by xjlin on 2017/3/15.
 */
public class InitialOrderTest_NoInitialTest {
    public static void main(String[] args) {

        /**
         * 输出：//SuperClass init!
         //123
         */
        System.out.println(SubClass.value);
    }

    /**
     * 被动使用类字段演示二：
     * 通过数组定义来引用类，不会触发此类的初始化
     **/
    SuperClass[] sca = new SuperClass[10];

}


/**
 * 被动使用类字段演示一：
 * 通过子类引用父类的静态字段，不会导致子类初始化
 **/
class SuperClass {

    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}

class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }
}
