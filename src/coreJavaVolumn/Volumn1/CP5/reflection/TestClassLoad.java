package coreJavaVolumn.Volumn1.CP5.reflection;

import java.lang.reflect.Method;

/**
 * Created by xjlin on 2018/8/28.
 */
public class TestClassLoad{
    public static void main(String[] args) throws Exception{
        Class<?> clz = Class.forName("coreJavaVolumn.Volumn1.CP5.reflection.AForReflection");
//        Class clz = Class.forName("coreJavaVolumn.Volumn1.CP5.reflection.AForReflection");  //此行也可以通过， 不用<?>也行
        Object o = clz.newInstance();
        Method m = clz.getMethod("foo", String.class);
        for(int i = 0; i < 16; i++){
            m.invoke(o, Integer.toString(i));
        }

        ClassLoader classLoader = clz.getClassLoader();
        System.out.println(classLoader);
    }
}
