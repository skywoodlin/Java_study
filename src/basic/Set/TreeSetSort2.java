package basic.Set;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 自然排序：TreeSet要添加哪个对象就在哪个对象类上面实现java.lang.Comparable接口，并且重写comparaTo()方法，
 * 返回0则表示是同一个对象，否则为不同对象。
 *
 * 此例中不按照hashCode和equals来判断， 只通过CompareTo来判断是否相同！！！！
 * 判断为相同的不会加入Treeset中。
 * Created by xjlin on 2017/5/14.
 */
public class TreeSetSort2 {
    public static void main(String[] args) {
        Set<Person2> set = new TreeSet<Person2>();
        Person2 s1 = new Person2("skywood", "lxj", 33);
        Person2 s2 = new Person2("changlei","changl", 29);
        Person2 s4 = new Person2("gcs", "gcs2", 34);
        Person2 s3 = new Person2("gcs", "gcs", 27);
        Person2 s5 = new Person2("tt", "tt", 10);
        //自然排序
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);
        System.out.println(set.size());
        for (Person2 s : set) {
            System.out.println(s);
        }

//        set.
    }
}

class mySort1 implements Comparator<Person2> {
    public int compare(Person2 o1, Person2 o2) {
        return (o2.getAge()-o1.getAge());  //倒序排列
    }
}


class Person2 implements Comparable<Person2>{
    Person2(String id, String name, int age) {
        setId(id);
        setName(name);
        setAge(age);
    }

    private String id;
    private String name;
    private int age;

    public int compareTo(Person2 o) {
        return (this.age-o.age);
    }

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
        if (obj instanceof Person2) {
            Person2 person = (Person2) obj;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
