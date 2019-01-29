package coreJavaVolumn.Volumn1.CP5.reflection;

import coreJavaVolumn.Volumn1.CP4.Employee;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Created by xjlin on 2018/8/28.
 * 暴力访问
 */
public class GetFieldValue{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException{
        Employee a = new Employee("skywoodlin", 33, 2008, 12,12);

        Class cl = Employee.class;
        Field field = cl.getDeclaredField("name");
        field.setAccessible(true); //因为name是一个private的， 不写这句会有IllegalAccessException错误， 暴力访问
        Object v = field.get(a);
        System.out.println(v);

        Field field2 = cl.getDeclaredField("salary");
        field2.setAccessible(true); //因为name是一个private的， 不写这句会有IllegalAccessException错误， 暴力访问
        //获取
        Object v2 = field2.get(a);
        double v22 = field2.getDouble(a);
        System.out.println(v2);
        System.out.println(v22);

        //设置
        field2.set(a, 333);
        Object v222 = field2.get(a);
        System.out.println(v222);


    }
}
