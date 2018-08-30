package coreJavaVolumn.Volumn1.CP5.reflection;

import coreJavaVolumn.Volumn1.CP4.Employee;

/**
 * Created by xjlin on 2018/8/28.
 */
public class ModifiersTest{
    public static void main(String[] args){
        int a =  Employee.class.getModifiers();
        System.out.println(a);
    }
}
