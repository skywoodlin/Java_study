package coreJavaVolumn.Volumn1.CP5;

import coreJavaVolumn.Volumn1.CP4.Employee;

/**
 * Created by xjlin on 2017/12/14.
 */
public class Manager extends Employee{

    private double bonus;
    private String testStr;
    private boolean aBoolean;

    public Manager(String n, double s, int year, int month, int day) {
        super(n,s,year,month,day);
        this.bonus = 0;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + this.bonus;
    }

    public void setBonus(double b) {
        bonus = b;
    }

    public double getBonus(){
        return bonus;
    }

    public String getTestStr(){
        return testStr;
    }

    public void setTestStr(String testStr){
        this.testStr = testStr;
    }

    public boolean isaBoolean(){
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean){
        this.aBoolean = aBoolean;
    }

    public void test() {

    }
}
