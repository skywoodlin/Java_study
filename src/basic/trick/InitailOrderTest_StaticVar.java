package basic.trick;

/**
 * Created by xjlin on 2017/3/15.
 * 输出为1， 2， 本以为是0， 2
 *
 * 解释： 静态变量、静态初始化块，变量、初始化块初始化了顺序取决于它们在类中出现的先后顺序。
 * 也就是说：应该是编译器先给static的变量赋值null（基类为值）， 再根据static初始化块以及静态变量
 * 的定义顺序来进行赋值（xjlin勉强解释）
 */
public class InitailOrderTest_StaticVar {
    static {
        i = 0;  //  给变量赋值可以正常编译通过
//        System.out.print(i);  // 这句编译器会提示“非法向前引用”
    }
    static int i = 1;

    static int j = 1;

    static{
        j = 2;
    }

    public static void main(String[] args){
        System.out.println(InitailOrderTest_StaticVar.i);  //1
        System.out.println(InitailOrderTest_StaticVar.j); //2
    }
}
