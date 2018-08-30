package DesignPattern.GunStrategy;

/**
 * Created by xjlin on 2018/7/19.
 * 定义一个环境类（GunContext），类中持有一个对公共接口的引用，以及相应的get、set方法、构造方法
 */
public class GunContext{
    Weapon weapon;

    public GunContext(Weapon weapon) { //构造函数
        super();
        this.weapon = weapon;
    }

    public Weapon getWeapon() { //get方法
        return weapon;
    }

    public void setWeapon(Weapon weapon) { //set方法
        this.weapon = weapon;
    }

    public void gun() {
        weapon.gun();
    }
}
