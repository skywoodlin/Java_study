package basic.forUmlShow.AnotherExam;

/**
 * Created by xjlin on 2019/1/29.
 */
/***********************************************************************
 * Module:  Person.java
 * Author:  Code4Android
 * Purpose: Defines the Class Person
 ***********************************************************************/

/** @pdOid 4615fa10-38a3-446e-a7d5-59dcb3e786b5 */
public class Person{
    /**
     * @pdOid f314a698-c3c1-4ec7-a8ea-f8b2df107a29
     */
    private String name = "zhangsan";
    /**
     * @pdOid 271c633b-87e5-4b41-9f70-2ce320635014
     */
    private int age = 23;

    /**
     * @pdOid ccf5b7c1-d005-4a5f-b823-9988f2dd6f91
     */
    public String getName(){
        // TODO: implement
        return name;
    }

    /**
     * @pdOid 83e01fba-b004-498e-b7ab-778de8be6dfa
     */
    public int getAge(){
        // TODO: implement
        return age;
    }

    /**
     * @param name
     * @pdOid 9525895a-11bf-44a3-afed-b4a014540a98
     */
    public void setName(String name){
        // TODO: implement
        this.name = name;
    }

    /**
     * @param age
     * @pdOid 16fd66cc-2af1-4fef-ae98-2a37f495a487
     */
    public void setAge(int age){
        // TODO: implement
        this.age = age;
    }
}