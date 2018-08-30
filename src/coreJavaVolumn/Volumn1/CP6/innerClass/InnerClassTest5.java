package coreJavaVolumn.Volumn1.CP6.innerClass;

import Vo.Person;

/**
 * Created by xjlin on 2018/8/29.
 *
 * 测试匿名内部类_继承
 *
 */


public class InnerClassTest5{
    public static void main(String[] args){
        //实例化person
        Person person = new Person();

        //匿名内部类,
        Person newPerson = new Person() {
            //
            private String newName;

            @Override
            public String getName(){
                return newName;
            }

            @Override
            public void setName(String newField){
                this.newName = newField;
            }
        };

        newPerson.setName("abc");
        System.out.println(newPerson.getName());


    }
}
