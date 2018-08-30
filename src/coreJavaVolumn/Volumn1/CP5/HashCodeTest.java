package coreJavaVolumn.Volumn1.CP5;

import java.util.Objects;

/**
 * Created by xjlin on 2018/8/21.
 */
public class HashCodeTest{
    public static void main(String[] args){
        //字符串不管是如何定义的，如果两个字符串是一样的， 它的hashcode就是一样的
        String aString = "a";
        String bString = "a";
        String cString = new String("a");
        String dString = new String("a");
        String eString = String.valueOf("ab");
        String fString = String.valueOf("ab");

        System.out.println(aString.hashCode());//97
        System.out.println(bString.hashCode());//97
        System.out.println(cString.hashCode());//97
        System.out.println(dString.hashCode());//97
        System.out.println(eString.hashCode());//3105
        System.out.println(fString.hashCode());//3105

        //每个对象都有一个默认的hashCode， 其值为对象的存储地址，
        StringBuilder sb1 = new StringBuilder("abb");
        StringBuilder sb2 = new StringBuilder("abb");
        System.out.println(sb1.hashCode());
        System.out.println(sb2.hashCode());


        /**
         * 基础类型的数据可以有hashCode()方法吗？
         */
        int a = 1;
//        System.out.println(a.hashCode());// 编译不过
        Objects.hash(1,2,3);
    }
}
