package coreJavaVolumn.Volumn1.CP5.reflection;

import coreJavaVolumn.Volumn1.CP5.reflection.domain.Person;

/**
 * Created by xjlin on 2018/12/10.
 *
 * 反射技术： 动态获取类以及类中的成员， 并可以调用该类成员
 * 以前是有什么类， 就new什么对象，
 * 没有类， 给什么类就new什么对象。
 *
 * 如何获取一个字节码文件的对象呢？
 *
 * 方式一：
 * Object getClass();方法： 实例.getClass()
 * 发现在反射技术里， 该方法不合适， 因为你事先不知道有什么类。
 *
 *
 *
 * 方式二：所有的数据类型都有自己对应的Class对象， 表示方式很简单。
 * 每一个数据类型都有一个默认的静态的属性： 类名.class
 * 用该属性就可以获得它的字节码对象。
 *
 * 虽然不是对象调用了， 但是还是要知道具体的类
 *
 *
 *
 * 方式三, Class.forName(), 通过类名（含包名）， 这个是重点，
 * 此方法执行后， 如果jvm中没有加载过此类， 则， 则将此类加载到虚拟机中，
 * 同时返回它的class对象， 后续可以用诸如newinstance()等方法创建class对应的对象
 *
 */
public class ReflectionDemo{
    public static void main(String[] args) throws ClassNotFoundException{
//        methodDemo_1();
//        methodDemo_2();
        methodDemo_3();
    }


    /**
     *  * 方式一：
     *  * Object getClass();方法： 实例.getClass()
     *  * 发现在反射技术里， 该方法不合适， 因为你事先不知道有什么类。
     */

    public static void methodDemo_1() {
//        Person p = new Person();
//        Class clazz = p.getClass();
//        System.out.println(clazz);
//
//        Person p2 = new Person();
//        Class clazz2 = p2.getClass();

//        System.out.println(clazz == clazz2); //true, 说明是同一个class
    }


    /**
     * * 方式二：所有的数据类型都有自己对应的Class对象， 表示方式很简单。
     *  * 每一个数据类型都有一个默认的静态的属性： 类名.class
     *  * 用该属性就可以获得它的字节码对象。
     *  *
     *  * 虽然不是对象调用了， 但是还是要知道具体的类
     */
    public static void methodDemo_2(){
        Class clazz = Person.class;
        Class clazz2 = Person.class;

        System.out.println(clazz == clazz2);  //true
    }


    /**
     *  * 方式三, Class.forName(), 通过类名（含包名）， 这个是重点
     * @throws ClassNotFoundException
     */
    public static void methodDemo_3() throws ClassNotFoundException{
        Class clazz = Class.forName("coreJavaVolumn.Volumn1.CP5.reflection.domain.Person");
        Class clazz2 = Class.forName("coreJavaVolumn.Volumn1.CP5.reflection.domain.Person");

        System.out.println(clazz == clazz2);

    }
}
