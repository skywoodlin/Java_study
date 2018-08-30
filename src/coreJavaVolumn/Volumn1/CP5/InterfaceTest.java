package coreJavaVolumn.Volumn1.CP5;

import coreJavaVolumn.Volumn1.CP4.Employee;

/**
 * Created by xjlin on 2018/8/23.
 */
public class InterfaceTest{
    public static void main(String[] args){
        InterfaceA_Imp a_imp = new InterfaceA_Imp();
        System.out.println(a_imp instanceof InterfaceA); //true 属于接口的

        System.out.println(a_imp instanceof Employee); //true 属于父类的

        InterfaceA a;
        Employee e;
        a = new InterfaceA_Imp();
        e = new InterfaceA_Imp();

//        a.test2(); //不行
        ((InterfaceA_Imp) a).test2(); //ok

//        e.test2(); //不行
        ((InterfaceA_Imp) e).test();
        ((InterfaceA_Imp) e).test2();

    }
}
