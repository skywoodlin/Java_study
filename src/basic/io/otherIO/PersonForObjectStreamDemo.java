package basic.io.otherIO;

import java.io.Serializable;

/**
 * Created by xjlin on 2018/10/19.
 */
public class PersonForObjectStreamDemo implements Serializable{
    private String name;
    private int age;

    public PersonForObjectStreamDemo(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString(){
        return "PersonForObjectStreamDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
