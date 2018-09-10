package coreJavaVolumn.Volumn1.CP6.proxy.LiuDeHuaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by xjlin on 2018/8/27.
 */
public class LiuDeHuaProxy{
    //设计一个类变量记住代理类要代理的目标对象
    private PersonForProxy ldh = new LiuDeHua();

    /**
     * @return
     * @Description: 这个方法返回刘德华的代理对象：
     * PersonForProxy person = LiuDeHuaProxy.getProxy();//得到一个代理对象
     */
    public PersonForProxy getProxy(){
        //使用Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
        // 返回某个对象的代理对象
        return (PersonForProxy) Proxy.newProxyInstance(LiuDeHuaProxy.class.getClassLoader(), ldh.getClass().getInterfaces(),
                new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method,
                                 Object[] args) throws Throwable{
                //如果调用的是代理对象的sing方法
                if(method.getName().equals("sing")){
                    System.out.println("我是他的经纪人，要找他唱歌得先给十万块钱！！");
                    //已经给钱了，经纪人自己不会唱歌，就只能找刘德华去唱歌！
                    return method.invoke(ldh, args); //代理对象调用真实目标对象的sing方法去处理用户请求
                }
                //如果调用的是代理对象的dance方法
                if(method.getName().equals("dance")){
                    System.out.println("我是他的经纪人，要找他跳舞得先给二十万块钱！！");
                    //已经给钱了，经纪人自己不会唱歌，就只能找刘德华去跳舞！
                    return method.invoke(ldh, args);//代理对象调用真实目标对象的dance方法去处理用户请求
                }

                return null;
            }
        });
    }
}
