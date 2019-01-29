package coreJavaVolumn.Volumn1.CP6.proxy.不错的例子From朴乾_代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by xjlin on 2018/12/6.
 */
public class 动态代理狗工厂{
    //设计一个类变量记住代理类要代理的目标对象
    private 动物 一只狗 = new 狗();

    /**
     * 第一个参数传入class loader， 没啥好说的额， 随便一个classloader都可以
     * 第二个参数表明要代理的方法， 这里我们传入要代理对象： 狗的所有方法， 表示要代理它的所有方法
     * 第三个参数传入一个匿名内部类， 代理狗每次执行一个方法都会扔到这里。
     * @return
     */
    public 动物 获取代理狗() {
        return (动物) Proxy.newProxyInstance(狗.class.getClassLoader(), 一只狗.getClass().getInterfaces(),
                new InvocationHandler(){
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
                        if(method.getName().equals("叫")) {
                            System.out.println("我要让他按我的办法叫");
                            System.out.println("代理狗i咳咳咳的叫");
                            return null;
                        } else{
                            System.out.println("其它方法就用它自己的方法吧！不过我要拦截一下");
                            return method.invoke(一只狗, args);
                        }

                    }
                });
    }

}
