package coreJavaVolumn.Volumn1.CP5;

import coreJavaVolumn.Volumn1.CP4.Employee;

/**
 * Created by xjlin on 2018/8/21.
 * 类对象默认的toString(): 类名@hashCode
 */
public class DefaultObjectToString{
    public static void main(String[] args){
        Employee a = new Employee();
        System.out.println(a.toString()); //coreJavaVolumn.Volumn1.CP4.Employee@64c
    }
}
