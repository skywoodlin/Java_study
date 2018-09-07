package medium.gc;

/**
 * Created by xjlin on 2018/9/3.
 */
public class FinalizeDemo{
    public static void main(String[] args){
        new Demo();
        new Demo();
        new Demo();
        new Demo();
        new Demo();
        System.gc(); //启动垃圾回收器
        System.out.println("hello world!");
    }
}


class Demo {
    //定义垃圾回收方法
    public void finalize() {
        System.out.println("此demo已经被回收");
    }
}
