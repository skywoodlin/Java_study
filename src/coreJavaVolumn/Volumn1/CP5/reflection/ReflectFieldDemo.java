package coreJavaVolumn.Volumn1.CP5.reflection;

import java.lang.reflect.Field;

/**
 * Created by xjlin on 2018/12/10.
 *
 * /**
 *          * 获取类中的成员
 *          * 反射字段
 *          */
public class ReflectFieldDemo{

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException, InstantiationException,
            IllegalAccessException{

        getFieldDemo();
    }


    /**
     *
     */
    public static void getFieldDemo() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException,
            InstantiationException{
        String className = "coreJavaVolumn.Volumn1.CP5.reflection.domain.Person";
        Class clazz = Class.forName(className);

        //获取字段, 可以配置在配置文件里头
        //getField只能拿到公有的属性（public）
        //getDeclareField可以拿到所有的
        Field field = clazz.getField("age");
        Field field2 = clazz.getDeclaredField("age");
        Field field3 = clazz.getDeclaredField("name");
        System.out.println(field);
        System.out.println(field2);
        System.out.println(field3);

        //要对非静态字段操作必须有对象
        Object object = clazz.newInstance();
        field.set(object, 40); //public字段随便设
//        field3.set(object, 40); //private属性不让访问

        //调用父类AccessibleObject的方法将访问检查取消！！
        field3.setAccessible(true);
        field3.set(object, "xjlin"); //暴力访问， 现在可以访问private属性


    }


}
