package coreJavaVolumn.Volumn1.CP6.proxy.coderProxy;

import coreJavaVolumn.Volumn1.CP6.proxy.LiuDeHuaProxy.LiuDeHua;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by xjlin on 2018/8/30.
 */
public class DynamicClient{

    public static void main(String args[]){
        //要代理的真实对象
        ICoder coder = new JavaCoder("Zhang");
        //创建中介类实例
        InvocationHandler handler = new CoderDynamicProxy(coder);
        //获取类加载器
        ClassLoader cl = coder.getClass().getClassLoader();

        /**
         * 下面是几个简单的小测试， 与代理无关
         */
        //测试1：所有用户自定义的类， 它们的ClassLoader都是一样的
        JavaCoder coder2 = new JavaCoder("skywoodlin");
        ClassLoader cl2 = coder2.getClass().getClassLoader();
        System.out.println("cl == cl2 ? " + (cl == cl2));  //true
        ClassLoader cl3 = LiuDeHua.class.getClassLoader();
        System.out.println("cl2 == cl3 ? " + (cl2 == cl3)); //true

        //测试2： 不管实例使用ICode还是JavaCoder接收的类型， 只要new 后面的类是一样的， 它们的Class就是一样的
        Class class1 = coder.getClass();
        Class class2 = coder2.getClass();
        System.out.println(class1);
        System.out.println(class2);
        System.out.println("class1 == class2 ? : " + (class1 == class2));  //true

        //动态产生一个代理类
        ICoder proxy = (ICoder) Proxy.newProxyInstance(cl, coder.getClass().getInterfaces(), handler);
        //通过代理类，执行doSomething方法；
        proxy.implDemands("Modify user management");
    }
}
