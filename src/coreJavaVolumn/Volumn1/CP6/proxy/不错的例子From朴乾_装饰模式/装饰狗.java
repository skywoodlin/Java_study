package coreJavaVolumn.Volumn1.CP6.proxy.不错的例子From朴乾_装饰模式;

/**
 * Created by xjlin on 2018/12/6.
 */
public class 装饰狗 implements 动物{
    private 动物 ani = null;

    public 装饰狗(动物 ani) {
        this.ani = ani;
    }
    @Override
    public void 吃(){
        System.out.println("狗在哈哈吃");
    }

    @Override
    public void 叫(){
        System.out.println("狗在咩咩叫");
    }
}
