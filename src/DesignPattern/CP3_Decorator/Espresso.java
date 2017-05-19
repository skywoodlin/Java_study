package DesignPattern.CP3_Decorator;

/**
 * Created by xjlin on 2017/3/22.
 */
public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
