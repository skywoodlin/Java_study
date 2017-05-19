package headfirst;

/**
 * Created by xjlin on 2017/3/16.
 */
public class OverAll_TestDuck {

    public static void main(String[] args) {

        DecoyDuck	decoy = new DecoyDuck();

        decoy.performFly();
    }
}

class DecoyDuck extends Duck {
    public DecoyDuck() {
        setFlyBehavior(new FlyNoWay());
    }
    public void display() {
        System.out.println("I'm a duck Decoy");
    }
}



abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public void setFlyBehavior (FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

    abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }
}

interface FlyBehavior {
    public void fly();
}
interface QuackBehavior {
    public void quack();
}

class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I can't fly");
    }
}