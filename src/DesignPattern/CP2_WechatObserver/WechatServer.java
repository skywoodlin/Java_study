package DesignPattern.CP2_WechatObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjlin on 2018/7/19.
 */
/**
 * 被观察者，也就是微信公众号服务
 * 实现了Observerable接口，对Observerable接口的三个方法进行了具体实现
 * @author xjlin
 *
 */
public class WechatServer implements Observerable{
    //注意到这个List集合的泛型参数为Observer接口，
    // 设计原则：面向接口编程而不是面向实现编程
    private List<Observer> observerList;
    private String message;

    public WechatServer() {
        observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(!observerList.isEmpty()) {
            observerList.remove(o);
        }
    }

    //遍历
    @Override
    public void notifyObserver() {
        for(int i = 0; i < observerList.size(); i++) {
            Observer oserver = observerList.get(i);
            oserver.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);

        //消息更新， 通知所有观察者
        notifyObserver();
    }

}
