package coreJavaVolumn.Volumn1.CP5.reflection;


import coreJavaVolumn.Volumn1.CP4.Employee;
import coreJavaVolumn.Volumn1.CP5.Manager;

/**
 * 反射
 * Created by xjlin on 2017/12/15.
 */
public class Reflection {
    public static void main(String[] args) {
        Employee [] staff = new Employee[3];
        staff[0] = new Manager("skywoodlin", 80000, 1983, 7,18);
        staff[1] = new Employee("xjlin", 40000, 1983, 7, 18);
        staff[2] = new Employee("goTjwen", 30000, 1984, 8, 29);

        for(int i = 0; i < staff.length; i++) {
            System.out.println(staff[i].getClass().getName() + " " + staff[i].getName());
        }
    }
}
