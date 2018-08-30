package java8.stream;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by xjlin on 2018/8/16.
 */
public class StreamTest1{
    public static void main(String[] args){
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));

        //filter(T -> boolean)
        //保留 boolean 为 true 的元素
        List<Person> list2 = list.stream().filter(person -> person.getAge() == 20).collect(toList());

        // forEach
        list2.stream().forEach(person ->
            System.out.println(person.getName()));

        // 处理后list不变， 生成新Collection
        list.stream().forEach(person -> System.out.println(person.getName()));

        //distinct
        list.stream().distinct().forEach(person -> System.out.println(person.getName()));






    }
}
