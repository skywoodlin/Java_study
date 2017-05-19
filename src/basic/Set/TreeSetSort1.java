package basic.Set;

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
public class TreeSetSort1 {
    public static void main(String[] args) {
        Set<Person1> set = new TreeSet<Person1>();
        Person1 s1 = new Person1("skywood", "lxj", 33);
        Person1 s2 = new Person1("changlei","changl", 29);
        Person1 s4 = new Person1("gcs", "gcs2", 34);
        Person1 s3 = new Person1("gcs", "gcs", 27);
        Person1 s5 = new Person1("tt", "tt", 34);
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);
        System.out.println(set.size());
        for (Person1 s : set) {
            System.out.println(s);
        }
    }
}


class Person1 implements Comparable<Person1> {
    Person1(String id, String name, int age) {
        setId(id);
        setName(name);
        setAge(age);
    }

    public int compareTo(Person1 o) {
        return (this.age-o.age);
    }


    private String id;
    private String name;
    private int age;

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
        if (obj instanceof Person1) {
            Person1 person = (Person1) obj;
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
