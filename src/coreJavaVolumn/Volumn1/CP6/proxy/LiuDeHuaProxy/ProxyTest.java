package coreJavaVolumn.Volumn1.CP6.proxy.LiuDeHuaProxy;

/**
 * Created by xjlin on 2018/8/27.
 */
public class ProxyTest{
    public static void main(String[] args) {

                LiuDeHuaProxy proxy = new LiuDeHuaProxy();
                //获得代理对象
                PersonForProxy p = proxy.getProxy();
                 //调用代理对象的sing方法
                 String retValue = p.sing("冰雨");
                 System.out.println(retValue);
                 //调用代理对象的dance方法
                 String value = p.dance("江南style");
                 System.out.println(value);
             }
}
