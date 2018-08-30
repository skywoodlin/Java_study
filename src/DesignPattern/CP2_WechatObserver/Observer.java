package DesignPattern.CP2_WechatObserver;

/**
 * Created by xjlin on 2018/7/19.
 */
/***
 * 抽象观察者
 * 定义了一个update()方法，当被观察者调用notifyObservers()方法时，
 * 观察者的update()方法会被回调。
 * @author xjlin
 *
 */
public interface Observer{
    void update(String message); //打印消息
}
