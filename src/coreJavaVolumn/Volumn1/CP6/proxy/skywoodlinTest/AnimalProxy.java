package coreJavaVolumn.Volumn1.CP6.proxy.skywoodlinTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by xjlin on 2018/8/31.
 */
public class AnimalProxy implements InvocationHandler{
    private Animal animal;

    public AnimalProxy(Animal animal) {
        this.animal = animal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("-----------------------------代理开始-------------------------------");
        Object a = method.invoke(animal, args);
        System.out.println("-----------------------------代理结束-------------------------------");
        return a;
    }
}
