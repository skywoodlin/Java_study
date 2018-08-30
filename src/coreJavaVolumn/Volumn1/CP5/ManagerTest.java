package coreJavaVolumn.Volumn1.CP5;

import coreJavaVolumn.Volumn1.CP4.Employee;

/**
 * Created by xjlin on 2017/12/14.
 */
public class ManagerTest {
    public static void main(String[] args) {
        Manager boss = new Manager("skywoodlin", 80000, 1983, 7,18);
        boss.setBonus(5000);

        Employee[] staff = new Employee[3];

        staff[0] = boss;
        staff[1] = new Employee("xjlin", 40000, 1983, 7, 18);
        staff[2] = new Employee("goTjwen", 30000, 1984, 8, 29);

        for(Employee e: staff) {
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary() + ", hireDay=" + e.getHireDay());
        }


    }
}
