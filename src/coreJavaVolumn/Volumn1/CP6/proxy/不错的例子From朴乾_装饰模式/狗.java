package coreJavaVolumn.Volumn1.CP6.proxy.不错的例子From朴乾_装饰模式;

/**
 * Created by xjlin on 2018/12/6.
 *
 * 装饰模式：
 * 装饰者和被装饰着实现同一接口， 使用父类接口来实现这个功能
 */
public class 狗 implements 动物{
    @Override
    public void 吃(){
        System.out.println("狗在么么么吃");
    }

    @Override
    public void 叫(){
        System.out.println("狗在汪汪汪叫");

    }

    public static void main(String[] args){
        狗 dog = new 狗();
        动物 ani = new 装饰狗(dog);

        ani.叫();
        ani.吃();
    }
}
