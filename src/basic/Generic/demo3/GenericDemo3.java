package basic.Generic.demo3;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by xjlin on 2018/9/10.
 * 此程序表明：
 * 1. 一个类要向加入TreeSet, 第一种方法是要实现： Comparable接口， 写法如下：
 *      public class PersonForGenericDemo3 implements Comparable<PersonForGenericDemo3>
 *
 * 2. 第二种方法是定义一个比较器， 实现Comparator, 然后传入Treeset， 写法如下：
 *      public class ComparatorByName implements Comparator<PersonForGenericDemo3> {
     *     @Override
     *     public int compare(PersonForGenericDemo3 o1, PersonForGenericDemo3 o2){
     *         int temp = o1.getName().compareTo(o2.getName());
     *         return temp == 0 ? o1.getAge() - o2.getAge() : temp;
     *     }
 * }
 *
 *    创建set时： Set<PersonForGenericDemo3> set2 = new TreeSet<>(new ComparatorByName());
 *
 * 3. 如果类实现了Comparable, 同时创建set时又传入了比较器， 则比较器优先级更高
 *
 *
 */
public class GenericDemo3{
    public static void main(String[] args){
//        Set<PersonForGenericDemo3> set = new TreeSet<>();
//
//        set.add(new PersonForGenericDemo3("abcd", 20));
//        set.add(new PersonForGenericDemo3("aa", 26));
//        set.add(new PersonForGenericDemo3("nba", 22));
//        set.add(new PersonForGenericDemo3("cba", 24));
//        set.add(new PersonForGenericDemo3("abc", 20));
//
//        for(PersonForGenericDemo3 person: set) {
//            System.out.println(person);
//        }

        Set<PersonForGenericDemo3> set2 = new TreeSet<>(new ComparatorByName());

        set2.add(new PersonForGenericDemo3("abcd", 20));
        set2.add(new PersonForGenericDemo3("aa", 26));
        set2.add(new PersonForGenericDemo3("nba", 22));
        set2.add(new PersonForGenericDemo3("cba", 24));
        set2.add(new PersonForGenericDemo3("abc", 20));

        for(PersonForGenericDemo3 person: set2) {
            System.out.println(person);
        }



    }
}
