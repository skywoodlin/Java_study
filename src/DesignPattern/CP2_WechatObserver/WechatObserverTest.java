package DesignPattern.CP2_WechatObserver;

/**
 * Created by xjlin on 2018/7/19.
 */
public class WechatObserverTest{
    public static void main(String[] args){
        WechatServer server = new WechatServer();
        Observer user1 = new User("skywoodlin");
        Observer user2 = new User("xjlin");
        Observer user3 = new User("skywood");

        server.registerObserver(user1);
        server.registerObserver(user2);
        server.registerObserver(user3);
        server.setInfomation("skywoodlin全世界最帅");

        System.out.println("--------------------------------------------");
        server.removeObserver(user1);
        server.setInfomation("skywoodlin全世界最帅2");
    }
}
