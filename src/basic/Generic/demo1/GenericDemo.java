package basic.Generic.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjlin on 2018/9/8.
 * 泛型：
 * 	在jdk1.4版本之前，容器什么类型的对象都可以存储。但是在取出时。需要用到对象的特有内容时，需要做向下转型。
 * 	但是对象的类型不一致，导致了向下转型发生了ClassCastException异常。
 * 	为了避免这个问题，只能主观上控制，往集合中存储的对象类型保持一致。
 *
 * 	JDK1.5以后解决了该问题，在定义集合时，就直接明确集合中存储元素的具体类型。
 * 	这样，编译器在编译时，就可以对集合中存储的对象类型进行检查。
 * 	一旦发现类型不匹配，就编译失败。这个技术就是泛型技术。
 *
 * 好处：
 * 	1，将运行时期的问题转移到了编译时期，可以更好的让程序员发现问题并解决问题。
 * 	2，避免了向下转型的麻烦。
 *
 * 总结：泛型就是应用在编译时期的一项安全机制。
 */
public class GenericDemo{
    public static void main(String[] args){
        List list = new ArrayList();
        list.add("abc");
        list.add(4); //list.add(Ingeter.valueOf(4));

        for(Object object: list) {
            System.out.println(object);
        }
    }
}
