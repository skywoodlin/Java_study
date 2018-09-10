package basic.Generic.demo6;

import medium.Serializable.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by xjlin on 2018/9/10.
 * 通配符学习
 */

public class GenericWildcard{

    /**
     * @param args
     */
    public static void main(String[] args){

        List<Student> list = new ArrayList<Student>();

        list.add(new Student("abc1", 21));
        list.add(new Student("abc2", 22));
        list.add(new Student("abc3", 23));
        list.add(new Student("abc4", 24));

        printCollection(list);

        Set<String> set = new HashSet<String>();
        set.add("haha");
        set.add("xixi");
        set.add("hoho");
        printCollection(set);


    }

    private static void printCollection(Collection<?> coll){//在不明确具体类型的情况下，可以使用通配符来表示。
        for(Iterator<?> it = coll.iterator(); it.hasNext(); ){
            Object obj = it.next();
            System.out.println(obj);
        }
    }

    /**
     * 下面这一个也可以
     * @param coll
     * @param <T>
     */
    private static <T> void printCollection2(Collection<T> coll){//在不明确具体类型的情况下，可以使用通配符来表示。
        for(Iterator<T> it = coll.iterator(); it.hasNext(); ){
            T tObj = it.next();
            System.out.println(tObj);
        }
    }
}