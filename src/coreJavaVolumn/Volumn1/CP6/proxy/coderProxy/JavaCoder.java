package coreJavaVolumn.Volumn1.CP6.proxy.coderProxy;

/**
 * Created by xjlin on 2018/8/30.
 */
public class JavaCoder implements ICoder{
    private String name;
    public JavaCoder(String name){
        this.name = name;
    }

    @Override
    public void implDemands(String demandName) {
        System.out.println(name + " implemented demand:" + demandName + " in JAVA!");
    }
}
