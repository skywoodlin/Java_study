package basic.Generic.demo5;

/**
 * Created by xjlin on 2018/9/10.
 */
public class GrnericInterface{
    public static void main(String[] args){
        SubInterImpl2 impl2 = new SubInterImpl2();

        impl2.show("abd");
    }
}

interface Inter<T> { //泛型接口
    public void show(T t);
}


class InterImpl implements Inter<String> {
    @Override
    public void show(String s){

    }
}

/**
 * 如果类上也不明确要实现什么类型
 */
class InterImpl2<W> implements Inter<W> {
    @Override
    public void show(W w){
        System.out.println("show: " + w);
    }
}

/**
 * 子类
 */
class SubInterImpl2 extends InterImpl2<String> {

}
