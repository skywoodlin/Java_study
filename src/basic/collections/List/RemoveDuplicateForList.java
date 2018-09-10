package basic.collections.List;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Created by xjlin on 2017/5/15.
 * 例子说明:
 * <p>
 * 1. String的hashCode, 当字符串一样的时候, hashCode也一样
 * 2. 对于HashSet, 判断两个对象(元素)都一样的标准是: equals()返回相同并且hashCode相同
 */
public class RemoveDuplicateForList{
    public static void main(String[] args){
        Person1 person1 = new Person1("1", "haha");
        Person1 person2 = new Person1("1", "haha");
        Person1 person3 = new Person1("2", "haha");
        Person1 person4 = new Person1("3", "haha2");

        List<Person1> list = new ArrayList<>();
        List<Person1> list2 = new ArrayList<>();
        List<Person1> list3 = new ArrayList<>();
        List<Person1> list4 = new ArrayList<>();


        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);

        list2.add(person1);
        list2.add(person2);
        list2.add(person3);
        list2.add(person4);

        list3.add(person1);
        list3.add(person2);
        list3.add(person3);
        list3.add(person4);

        list4.add(person1);
        list4.add(person2);
        list4.add(person3);
        list4.add(person4);


        RemoveDuplicateForList.method1(list);
        for(Person1 p : list){
            System.out.println(p.getId());
        }

//        RemoveDuplicateForList.method2(list2);
//        for(Person1 p: list2) {
//            System.out.println(p.getId());
//        }

//
//        RemoveDuplicateForList.method1(list1);
//        for(String p: list3) {
//            System.out.println(p);
//        }

//        RemoveDuplicateForList.method2(list2);
//        for(String p: list4) {
//            System.out.println(p);
//        }

        RemoveDuplicateForList.method3(list3);
        for(Person1 p: list3) {
            System.out.println(p);
        }

        List<Person1> result4 = RemoveDuplicateForList.method4(list4);
        for(Person1 p: result4) {
            System.out.println(p);
        }
    }

    public static void method1(List list){
        Set set = new HashSet();
        List newList = new ArrayList();
        for(Iterator iter = list.iterator(); iter.hasNext(); ){
            Object element = iter.next();
//            System.out.println(element.hashCode());
            if(set.add(element)){
                newList.add(element);
            }
        }

        list.clear();
        list.addAll(newList);
    }

    public static List method2(List list){
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }

    public static void method3(List list){
        for(int i = 0; i < list.size(); i++){
            for(int k = i + 1; k < list.size(); k++){
                if(list.get(i).equals(list.get(k))){
                    list.remove(k);
                    k--; //list里的数组已经左移一位了
                }
            }
        }
    }

    public static List method4(List list){
        List newList = new ArrayList();
        for(int i = 0; i < list.size(); i++){
            if(!newList.contains(list.get(i))) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }
}

class Person1{
    Person1(String id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        Person1 otherPerson = (Person1)obj;

        return id.equals(((Person1) obj).getId()) && name.equals(((Person1) obj).getName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name);
    }

    private String id;
    private String name;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Person1{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
