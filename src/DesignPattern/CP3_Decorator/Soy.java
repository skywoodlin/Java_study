package DesignPattern.CP3_Decorator;

/**
 * Created by xjlin on 2017/3/22.
 */
public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return 0.80 + beverage.cost();
    }
}
