package DesignPattern.CP3_Decorator;

/**
 * Created by xjlin on 2017/3/22.
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return 3.33;
    }
}
