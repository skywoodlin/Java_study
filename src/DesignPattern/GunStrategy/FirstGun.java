package DesignPattern.GunStrategy;

/**
 * Created by xjlin on 2018/7/19.
 * 定义具体的策略类(ConcreteStrategy)，实现上面的Weapon接口
 *
 */
public class FirstGun implements Weapon{
    @Override
    public void gun(){
        System.out.println("使用AWM狙击步枪。");
    }
}
