package coreJavaVolumn.Volumn1.CP6.proxy.LiuDeHuaProxy;

/**
 * Created by xjlin on 2018/8/27.
 */
public class LiuDeHua implements PersonForProxy{
    @Override
    public String sing(String name){
        System.out.println("刘德华唱" + name + "歌！！");
        return "歌唱完了， 谢谢大家！";
    }

    @Override
    public String dance(String name){
        System.out.println("刘德华跳" + name + "舞！！");
        return "舞跳完了， 谢谢观众！";
    }
}