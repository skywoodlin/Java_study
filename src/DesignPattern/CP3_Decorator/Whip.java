package DesignPattern.CP3_Decorator;

/**
 * Created by xjlin on 2017/3/22.
 */
public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return 0.66 + beverage.cost();
    }
}
