package coreJavaVolumn.Volumn1.CP6.proxy.skywoodlinTest;

/**
 * Created by xjlin on 2018/8/31.
 */
public class Dog implements Animal{
    @Override
    public void speak(){
        System.out.println("woo~~woo~~");
    }

    @Override
    public String getFood(){
        return "bones";
    }
}
