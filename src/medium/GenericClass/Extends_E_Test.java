package medium.GenericClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjlin on 2018/8/22.
 * *https://blog.csdn.net/zymx14/article/details/78073757
 *  * 为知笔记里也有
 *  * 用途： 生产者（详见文章）
 */
public class Extends_E_Test{
    public static void main(String[] args){
        /**
         * 很明显，编译的时候报错了。man是people的子类，ArrayList是List的子类，但并不代表List<Man>是List<People>的子类。所以便有了有限通配符
         * <? extends E> 是 Upper Bound（上限） 的通配符，用来限制元素的类型的上限，
         */
//        List<People> list = new ArrayList<Man>();//编译不过

        /**
         * 表示集合中的元素上限是People，即只能是People
         * 或People的子类，所以下面的赋值是合法的，编译时候不会报错
         */
        List<? extends Man> list1 = null;
        list1 = new ArrayList<Man>(); //ok

        List<? extends Man> list2 = null;
        list2 = new ArrayList<Boy>(); //ok


        /**
         * 但不能是People的父类
         */
        List<? extends Man> list3 = null;
//        list3 = new ArrayList<People>(); //编译不过
    }
}
