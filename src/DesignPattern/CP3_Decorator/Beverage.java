package DesignPattern.CP3_Decorator;

/**
 * Created by xjlin on 2017/3/22.
 */
public abstract class  Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
