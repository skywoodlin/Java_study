package medium.Serializable;

import java.io.Serializable;

/**
 * Created by xjlin on 2018/8/23.
 */
public class Student implements Serializable{
    public static String countryName = "China";
    private int id;
    private String name;
    private String sex;

    public String getSex(){

        return sex;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString(){
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName(){
        String s = "adaf";
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
