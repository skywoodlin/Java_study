package coreJavaVolumn.Volumn1.CP5.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by xjlin on 2018/12/10.
 */
public class ReflectMethodDemo{

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException, InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException{
        /**
         * 获取类中的成员
         * 反射字段
         */
//        getMethodDemo();
//        getMethodDemo2();
        getMethodDemo3();
    }


    /**
     * 反射方法， 非静态， 无参
     */
    public static void getMethodDemo() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException{
        String className = "coreJavaVolumn.Volumn1.CP5.reflection.domain.Person";
        Class clazz = Class.forName(className);
        Method method = clazz.getMethod("show", null);
        Object object = clazz.newInstance();
        method.invoke(object, null);
    }

    /**
     * 反射方法， 静态， 无参
     */
    public static void getMethodDemo2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            IllegalAccessException{
        String className = "coreJavaVolumn.Volumn1.CP5.reflection.domain.Person";
        Class clazz = Class.forName(className);
        Method method = clazz.getMethod("staticShow", null);
        method.invoke(null, null);
    }

    /**
     * 反射方法， 非静态， 有参
     */
    public static void getMethodDemo3() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException{
        String className = "coreJavaVolumn.Volumn1.CP5.reflection.domain.Person";
        Class clazz = Class.forName(className);
        Method method = clazz.getMethod("paramShow", String.class, int.class);
        Object object = clazz.newInstance();
        method.invoke(object, "xjlin", 40);
    }


}
