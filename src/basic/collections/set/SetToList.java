package basic.collections.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xjlin on 2017/5/14.
 */
public class SetToList {
    public static void main(String[] args) {
        Set<Person4> set = new HashSet();


        Person4 p1 = new Person4(2, "skywoodlin2");
        Person4 p2 = new Person4(1, "skywoodlin1");
        Person4 p3 = new Person4(4, "skywoodlin4");
        Person4 p4 = new Person4(3, "skywoodlin3");
        Person4 p5 = new Person4(4, "skywoodlin5");
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);

        System.out.println("Set:");
        for (Person4 person : set) {
            System.out.println(person.getId() + ": " + person.getName());
        }

        //set转List
        List<Person4> person4List = new ArrayList<>(set);
        System.out.println("List:");
        for (Person4 person : person4List) {
            System.out.println(person.getId() + ": " + person.getName());
        }

        //对List排序， 客户化排序， 注意 返回值为-1， 1
        Collections.sort(person4List, new Comparator<Person4>() {
            @Override
            public int compare(Person4 o1, Person4 o2) {
                return o1.getId() < o2.getId() ? -1 : 1;
            }
        });

        System.out.println("After List sort:");
        for (Person4 person : person4List) {
            System.out.println(person.getId() + ": " + person.getName());
        }


    }


}

class Person4 {
    Person4(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;

    @Override
    public String toString() {
        return this.id + "";
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person4) {
            Person4 stu = (Person4) obj;
            if (stu.id == this.id)
                return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
