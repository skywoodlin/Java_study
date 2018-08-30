package coreJavaVolumn.Volumn1.CP6.innerClass;

import Vo.Person;

/**
 * Created by xjlin on 2018/8/29.
 *
 * 测试匿名内部类_实现接口
 * 同InnerClassTest5参照着看
 *
 */


public class InnerClassTest6{
    public static void main(String[] args){
        InnerClassTestInterface interfacetest = new InnerClassTestInterface(){
            @Override
            public void action(){
                System.out.println("innerclass");
            }
        };

        interfacetest.action();
    }
}


interface InnerClassTestInterface {
    void action();
}