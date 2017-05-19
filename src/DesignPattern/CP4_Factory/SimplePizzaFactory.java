package DesignPattern.CP4_Factory;


/**
 * Created by xjlin on 2017/3/28.
 */
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        }else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        }
        else if (type.equals("clam")) {
            pizza = new ClamPizza();
        }
        else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}
