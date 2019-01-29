package coreJavaVolumn.Volumn1.CP5.reflection.domain;

import java.util.Objects;

/**
 * Created by xjlin on 2018/12/10.
 */
public class Person{
    private String name;
    public int age;

    public Person() {
        super();
        System.out.println("Person run");

    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public void show(){
        System.out.println("person show run");
    }

    public static void staticShow(){
        System.out.println("person static show run");
    }

    public void paramShow(String name,int age){
        System.out.println("show:"+name+"---"+age);
    }

    public boolean equals1(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    public int hashCode1(){
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, age);
    }
}
