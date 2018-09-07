package medium.classLoader;

import coreJavaVolumn.Volumn1.CP4.Employee;
import coreJavaVolumn.Volumn1.ProblemTest.EmployeeProblemTest;

/**
 * Created by xjlin on 2018/8/29.
 * 验证不同的实例的classloader是否是一样的： 结论， 是的
 */
public class ClassLoaderTest1{
    public static void main(String[] args){
        ClassLoader a = Employee.class.getClassLoader();
        ClassLoader b = EmployeeProblemTest.class.getClassLoader();
        System.out.println(a == b);  //true ， 果然是一样的
        System.out.println(a); //sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}
