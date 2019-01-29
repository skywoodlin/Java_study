package coreJavaVolumn.Volumn1.CP6.proxy.不错的例子From朴乾_代理模式;

/**
 * Created by xjlin on 2018/12/6.
 */
public class 代理狗测试{
    public static void main(String[] args){

//        final 狗 dog = new 狗();

        /**
         * 不能直接找狗， 我们只能找代理狗
         */
        动态代理狗工厂 代理狗工厂 = new 动态代理狗工厂();
        动物 代理狗 = 代理狗工厂.获取代理狗();

        代理狗.吃();
        代理狗.叫();
    }
}
