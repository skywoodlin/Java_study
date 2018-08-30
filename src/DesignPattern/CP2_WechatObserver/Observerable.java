package DesignPattern.CP2_WechatObserver;


/**
 * Created by xjlin on 2018/7/19.
 */
/***
 * 抽象被观察者接口
 * 声明了添加、删除、通知观察者方法
 * @author xjlin
 *
 */
public interface Observerable{
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
