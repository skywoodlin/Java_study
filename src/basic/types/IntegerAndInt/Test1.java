package basic.types.IntegerAndInt;

/**
 * 解释：
 * 1、无论值是否相同，Integer与new Integer都不会相等，结果为false。
 情况一：
 Integer 范围在-128-127，指向专门存放他的内存（常量池）
 new Integer 引用指向堆
 他们的内存地址不一样，所以无论值是否相同，作比较结果都为false
 情况二：
 Integer 范围不在-128-127，则编译的时候 Integer.valueOf(值)本质返回的是new Integer()
 new Integer 引用指向堆
 这样二者是两个不同的堆栈对象，无论堆上的值是否相同，引用地址不同，结果为false；
 参见3
 情况三：
 两个Integer范围都不在-128-127之间，那么依然是两new Integer对象
 参见3
 2、两个都是非new出来的Integer，如果数在-128到127之间，值相同则是true,否则为false
 java在编译Integer 的时候,被翻译成-> Integer i = Integer.valueOf(值);而valueOf()函数会对-128到127之间的数进行缓存
 3、两个都是new出来的,无论堆上的值是否相同，引用地址不同，结果为false
 4、int和integer(无论是new出来的/-128-127常量池中)比，值相同则是true,否则为false， 因为会把Integer自动拆箱为int再去比
 */

/**
 * Created by xjlin on 2017/12/14.
 */
public class Test1 {
    public static void main(String[] args) {
        int ok = 1;
        Integer ok1 = 1;
        System.out.println(ok1 == ok);  //true

        //网上摘抄
        int i = 128;
        Integer i2 = 128;
        Integer i3 = new Integer(128);
        System.out.println(i == i2);        //Integer会自动拆箱为int，所以为true
        System.out.println(i == i3);        //Integer会自动拆箱为int，所以为true
        System.out.println(i2 == i3);      // false, new Integer 引用指向堆, 这样二者是两个不同的堆栈对象，无论堆上的值是否相同，引用地址不同，结果为false；
        System.out.println("**************");

        Integer i5 = 127;//java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);
        Integer i6 = 127;
        System.out.println(i5 == i6);//true

        Integer ii5 = new Integer(127);
        System.out.println(i5 == ii5); //false
        Integer i7 = new Integer(128);
        Integer i8 = new Integer(128);
        System.out.println(i7 == i8);  //false



    }
}
