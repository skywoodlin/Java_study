package medium.GenericClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjlin on 2018/8/22.
 * https://blog.csdn.net/zymx14/article/details/78073757
 * 为知笔记里也有
 * 用途： 消费者（详见文章）
 */
public class Super_E_Test{
    public static void main(String[] args){
        /**
         <? super E> 是 Lower Bound（下限） 的通配符 ，用来限制元素的类型下限
         */

        /**
         该表示给出了集合中元素的下限是Man，即只能为Man或者Man的父类，而不能是Man的子类，如下：
         */
        List<? super Man> list1 = null;
        list1 = new ArrayList<Man>(); //ok

        List<? super Man> list2 = null;
        list2 = new ArrayList<People>(); //ok


        /**
         * 但不能是Man的子类
         */
        List<? super Man> list3 = null;
//        list3 = new ArrayList<Boy>(); //编译不过
    }
}
