package coreJavaVolumn.Volumn1.CP4;

/**
 * Created by xjlin on 2017/12/14.
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("xjlin", 40000, 1983, 7, 18);
        staff[2] = new Employee("goTjwen", 30000, 1984, 8, 29);

        for(Employee e: staff) {
            e.raiseSalary(5);
        }

        for(Employee e: staff) {
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary() + ", hireDay=" + e.getHireDay());
            System.out.println("hashCode(): " + e.hashCode());
        }

    }
}
