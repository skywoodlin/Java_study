package basic.trick;

/**
 * Created by xjlin on 2018/12/6.
 *子类构造函数中要不要调用super()？
 *
 * 子类构造函数必须在构造函数第一行调用父类构造函数，
 * 当子类构造函数没有调用父类构造函数的时候是因为父类构造包含无参构造函数，为了节省代码，系统会自动添加调用。
 *
 */
public class 子类要显式调用父类的super吗{
    public static void main(String[] args){
        /**
         * 调用了father的无参构造函数
         */
        ChildForClassTest test = new ChildForClassTest();
        ChildForClassTest test2 = new ChildForClassTest("a");

    }
}

class FatherForClassTest{
    private String a;
    FatherForClassTest() {
        System.out.println("father default constructor");
    }

    FatherForClassTest(String a) {
        this.a = a;
        System.out.println("father non-Default constructor");
    }
}

class ChildForClassTest extends FatherForClassTest{
    ChildForClassTest() {
        System.out.println("child default constructor");
    }

    ChildForClassTest(String a) {
        super(a);
        System.out.println("child non-default constructor");
    }

}
