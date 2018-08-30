package coreJavaVolumn.Volumn1.CP5;

import coreJavaVolumn.Volumn1.CP4.Employee;

/**
 * Created by xjlin on 2018/8/21.
 */
public class GetNameTest{
    public static void main(String[] args){
        Employee employee = new Employee();
        System.out.println(employee.getClass().getName()); //coreJavaVolumn.Volumn1.CP4.Employee
        System.out.println(employee.getClass());//class coreJavaVolumn.Volumn1.CP4.Employee
        System.out.println(employee.getClass().getSuperclass());//class java.lang.Object

    }
}
