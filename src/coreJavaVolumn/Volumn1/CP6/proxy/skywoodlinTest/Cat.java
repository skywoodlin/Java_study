package coreJavaVolumn.Volumn1.CP6.proxy.skywoodlinTest;

/**
 * Created by xjlin on 2018/8/31.
 */
public class Cat implements Animal{
    @Override
    public void speak(){
        System.out.println("miao~~miao~~");
    }

    @Override
    public String getFood(){
        return "fish";
    }
}
