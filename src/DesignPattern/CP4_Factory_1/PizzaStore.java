package DesignPattern.CP4_Factory_1;

/**
 * Created by xjlin on 2017/3/28.
 */
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;

    }

    abstract  Pizza createPizza(String type);
}
