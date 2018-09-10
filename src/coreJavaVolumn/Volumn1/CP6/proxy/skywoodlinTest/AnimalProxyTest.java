package coreJavaVolumn.Volumn1.CP6.proxy.skywoodlinTest;

import java.lang.reflect.Proxy;

/**
 * Created by xjlin on 2018/8/31.
 */
public class AnimalProxyTest{
    public static void main(String[] args){
        System.out.println("--------------------dog测试开始-----------------------------");
        Animal dog = (Animal) Proxy.newProxyInstance(AnimalProxyTest.class.getClassLoader(), new Class<?>[]{Animal.class}, new
                AnimalProxy(new Dog()));
        dog.speak();
        String a = dog.getFood();
        System.out.println(dog.getFood());
        System.out.println("--------------------dog测试结束-----------------------------");
        System.out.println("--------------------cat测试开始-----------------------------");
        Animal cat = (Animal) Proxy.newProxyInstance(AnimalProxyTest.class.getClassLoader(), new Class<?>[]{Animal.class}, new
                AnimalProxy(new Cat()));
        cat.speak();
        System.out.println(cat.getFood());
        System.out.println("--------------------cat测试结束-----------------------------");
    }
}
