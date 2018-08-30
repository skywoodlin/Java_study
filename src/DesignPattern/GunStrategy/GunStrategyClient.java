package DesignPattern.GunStrategy;

/**
 * Created by xjlin on 2018/7/19.
 * 策略模式，小结一下：
 *
 * 重点在于：给对象传入什么样的策略，就执行什么样的动作。
 * 优点在于：可以轻易的扩展与改变策略，可以动态改变对象的行为。
 * 缺点在于：客户端必须知道所有的策略类，并自行决定使用哪一种。每个具体的策略都会产生一个新类，这样会造成很多策略类。
 */
public class GunStrategyClient{
    public static void main(String[] args){
        //使用构造函数默认选择一把AWM狙击步枪（一个策略）
        GunContext context = new GunContext(new FirstGun());
        context.gun();

        //使用get、set方法切换到S12K霰弹枪（切换策略）
        System.out.println("------右前方30米发现敌人------");
        context.setWeapon(new SecondGun());
        context.gun();
    }
}
