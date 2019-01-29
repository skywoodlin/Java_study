package DesignPattern.xjlinTest.singleton;

/**
 * Created by xjlin on 2018/12/17.
 * 测试静态内部类实现单例模式
 *  * 这种方式：线程安全，调用效率高，并且实现了延时加载！
 */
public class SingletonDemo4{
    private static class SingletonDemo4Instance{
        //使用了final， 保证只有一个
        private static final SingletonDemo4 instance = new SingletonDemo4();
    }

    private SingletonDemo4(){

    }

    //方法没有同步，调用效率高！
    public static SingletonDemo4 getInstance() {
        return SingletonDemo4Instance.instance;
    }
}
