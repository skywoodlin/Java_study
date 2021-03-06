package coreJavaVolumn.Volumn1.CP4;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * Created by xjlin on 2017/12/14.
 */
public class Employee implements Comparable, Cloneable{
    private String name;
    private double salary;
    private Date hireDay;
    private Cat cat;

    public Cat getCat(){
        return cat;
    }

    public void setCat(Cat cat){
        this.cat = cat;
    }

    public Employee() {
        //默认构造函数， 反射用
    }
    //constructor
    public Employee(String n, double s, int year, int month, int day) {
        this.name = n;
        this.salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        this.hireDay = calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /**
     * 一个标准的equals方法
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        Employee otherEmp = (Employee)obj;

        return name.equals(otherEmp.getName()) && salary == otherEmp.salary && hireDay.equals(((Employee) obj).getHireDay());
    }

    /*@Override  标准写法
    public int hashCode(){
        return Objects.hash(name, salary, hireDay);
    }*/

    //或者自己写, 自己发挥
    @Override
    public int hashCode(){
        return 31 * Objects.hash(name) + 21 * Objects.hash(salary);
    }

    @Override
    public int compareTo(Object otherObject){
        Employee other = (Employee) otherObject;
        return Double.compare(salary, other.salary);
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }


}
