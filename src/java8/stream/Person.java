package java8.stream;

/**
 * Created by xjlin on 2018/8/16.
 */
public class Person{

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private String name;
    private int age;

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
    public boolean equals(Object obj){
        return ((Person)obj).getName().equals(this.getName());
    }

    //    public boolean equals(Person person){
//        return this.name.equals(person.getName());
//    }
}
