package basic.Generic.demo4;

import javax.swing.*;

/**
 * Created by xjlin on 2018/9/10.
 */
public class GenericMethod <W>{
    public static void main(String[] args){
        Demo4<String> demo4  = new Demo4<>();
        demo4.show("abc");
        demo4.print(7);
        demo4.print("kkk");

        Demo4.show2(7);
    }
}

class Demo4<W> {
    /**
     * 静态方法时无法访问类上定义的泛型的， 因为类上的泛型只有在new的时候才能确定其类型
     * 如果静态方法需要定义泛型， 泛型只能定义在方法上
     * @param k
     */
//    public static void show2(W w) {
//        System.out.println("show2: " + w);
//    }
    public  static <K> void show2(K k){
        System.out.println("in static show2: " + k);
    }

    public void show(W w) {
        System.out.println("show: " + w);
    }

    public <Q> void print (Q q) { //泛型方法
        System.out.println("print: " + q);
    }
}