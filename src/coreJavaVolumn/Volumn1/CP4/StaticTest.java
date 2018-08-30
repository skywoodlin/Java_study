package coreJavaVolumn.Volumn1.CP4;

/**
 * Created by xjlin on 2018/2/8.
 * 注意， 最好不要使用对象来访问静态变量或者静态方法
 *
 * 静态变量应该叫做类变量， 静态方法也应该叫做类方法
 *
 */
public class StaticTest {
    private static int counter = 0;

    public static void main(String[] args) {
        StaticTest staticTest = new StaticTest();
        staticTest.addCounter();

        StaticTest staticTest2 = new StaticTest();
        staticTest2.addCounter();
    }

    public void addCounter() {
        System.out.println(this.counter);
        this.counter++;
        System.out.println(this.counter);
    }
}


