package coreJavaVolumn.Volumn1.CP5.reflection;

import coreJavaVolumn.Volumn1.CP4.Employee;
import coreJavaVolumn.Volumn1.CP5.Manager;

import java.lang.reflect.Field;
import java.util.Scanner;

/**
 * Created by xjlin on 2017/12/15.
 *
 */
public class ReflectionTest2{
    public static void main(String[] args) throws Exception{

        //方式1
        Employee employee = new Employee("xjlin", 40000, 1983, 7, 18);
        Class cl1 = employee.getClass();
        System.out.println(cl1);

        //方式2
        String className = "coreJavaVolumn.Volumn1.CP4.Employee";
        Class cl2 = Class.forName(className);
        System.out.println(cl2);

        //方式3
        Class cl3 = Employee.class;
        System.out.println(cl3);

        System.out.println(cl1 == cl2);
        System.out.println(cl1 == cl3);

        //根据Class创建对象
        Object a = cl2.newInstance();

        //
        Manager manager = new Manager("skywoodlin", 33.33, 2018, 8, 3);
        Class managerClass = Manager.class;
        Field[] ab = managerClass.getFields();
        System.out.println(" ");


    }}
