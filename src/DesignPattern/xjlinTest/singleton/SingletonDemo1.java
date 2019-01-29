package DesignPattern.xjlinTest.singleton;

/**
 * Created by xjlin on 2018/12/17.
 *
 * //饿汉式， 初始化时立即加载对象
 */
public class SingletonDemo1{
    //类初始化时，立即加载这个对象（没有延时加载的优势）。加载类时，天然的是线程安全的！
    private static SingletonDemo1 instance = new SingletonDemo1(); //饿汉式， 初始化时立即加载对象

    private SingletonDemo1(){

    }

    public static SingletonDemo1 getInstance() {
        return instance;
    }
}
