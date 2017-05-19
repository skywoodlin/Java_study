package basic.List;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by xjlin on 2017/5/15.
 */
public class RemoveDuplicateForList {
    public static void main(String[] args) {
        Person1 person1 = new Person1("1", "haha");
        Person1 person2 = new Person1("1", "haha");
        Person1 person3 = new Person1("2", "haha");
        Person1 person4 = new Person1("3", "haha2");

        List<Person1> list = new ArrayList<>();
        List<Person1> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();


        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);

        list2.add(person1);
        list2.add(person2);
        list2.add(person3);
        list2.add(person4);

        list3.add("skywoodlin");
        list3.add("capan");
        list3.add("csgong");
        list3.add("skywoodlin");
        list3.add("csgong");

        list4.add("skywoodlin");
        list4.add("capan");
        list4.add("csgong");
        list4.add("skywoodlin");
        list4.add("csgong");

/*        RemoveDuplicateForList.method1((ArrayList)list);
        for(Person1 p: list) {
            System.out.println(p.getId());
        }

        RemoveDuplicateForList.method2((ArrayList)list2);
        for(Person1 p: list2) {
            System.out.println(p.getId());
        }*/

        RemoveDuplicateForList.method1((ArrayList)list3);
        for(String p: list3) {
            System.out.println(p);
        }

        RemoveDuplicateForList.method2((ArrayList)list4);
        for(String p: list4) {
            System.out.println(p);
        }
    }

    public static void method1(ArrayList list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            Object element = iter.next();
            System.out.println(element.hashCode());
            if (set.add(element)) {
                newList.add(element);
            }
        }

        list.clear();
        list.addAll(newList);
    }

    public static List method2(ArrayList list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }
}

class Person1 {
    Person1(String id, String name) {
        this.id = id;
        this.name = name;

    }


    private String id;
    private String name;

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
}
