package basic.Generic.demo3;

/**
 * Created by xjlin on 2018/9/10.
 */
public class PersonForGenericDemo3 implements Comparable<PersonForGenericDemo3>{

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

    public PersonForGenericDemo3(){
        super();
    }

    public PersonForGenericDemo3(String name, int age){
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(PersonForGenericDemo3 o){
        int temp = this.age - o.age;
        return temp == 0 ? this.name.compareTo(o.name) : temp;
    }

    @Override
    public String toString(){
        return "PersonForGenericDemo3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
