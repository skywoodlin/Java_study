package basic.collections.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xjlin on 2017/5/9.
 * HashSet, 判断1. hashCode()  2. equals()是否相同， 相同则认为是同一个对象， 不会添加到hashSet中
 * 我们可以根据自己的业务对上面两个函数进行override
 * HashSet使用的是相当复杂的方式来存储元素的，使用HashSet能够最快的获取集合中的元素，
 * 效率非常高（以空间换时间）。会根据hashcode和equals来判断是否是同一个对象，如果hashcode一样，
 * 并且equals返回true，则是同一个对象，不能重复存放。
 */
public class ListSetTest {
    public static void main(String[] args) {
        Person a = new Person("skywoodlin", "lxj");
        Person b = new Person("skywoodlin", "lxjtc");

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a.equals(b));

        Set<Person> set = new HashSet<>();
        set.add(a);
        set.add(b);
        System.out.println(set.size());

        for (Person s : set) {
            System.out.println(s);
        }

    }
}

class Person {
    Person(String id, String name) {
        setId(id);
        setName(name);
    }


    private String id;
    private String name;
    private String sex;

    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            if (person.id.equals(this.id)) {
                return true;
            }
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
