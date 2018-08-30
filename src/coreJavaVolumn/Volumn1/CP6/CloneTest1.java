package coreJavaVolumn.Volumn1.CP6;

import coreJavaVolumn.Volumn1.CP4.Cat;
import coreJavaVolumn.Volumn1.CP4.Employee2;

import java.io.InputStream;
import java.util.Date;


/**
 * Created by xjlin on 2018/8/24.
 *
 * Object.clone()是浅拷贝
 */
public class CloneTest1{
    public static void main(String[] args) throws CloneNotSupportedException{
        Employee2 e1 = new Employee2("xjlin", 33, 2017,8,20,"cat1");
        Employee2 e2 = e1.clone();

        e2.setName("gotjwen");
        e2.setHireDay(new Date());
        Cat cat2 = new Cat();
        cat2.setName("cat2");
        e2.setCat(cat2);
        System.out.println(e1.getCat());
        System.out.println(e2.getCat());
    }
}
