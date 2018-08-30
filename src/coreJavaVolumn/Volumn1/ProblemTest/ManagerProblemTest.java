package coreJavaVolumn.Volumn1.ProblemTest;

/**
 * Created by xjlin on 2018/8/28.
 * 测试用Class.newInstance()能否对无默认构造函数的类初始化： 结论： 不行
 */
public class ManagerProblemTest extends EmployeeProblemTest{
    ManagerProblemTest() {
        /**
         * 一定要写这一句， 不然编译不过。
         * 因为EmployeeProblemTest没有提供默认构造函数
         */
        super("a", 33,2018,10,33);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException{
        /**
         * 使用newInstance， EmployeeProblemTest一定要带默认无参的构造函数， 否则执行的时候会报init错误
         */
        EmployeeProblemTest a = EmployeeProblemTest.class.newInstance();
        System.out.println(a.getName());
    }
}
