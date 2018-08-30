package basic.keywordVisiability.protectedTest.p33;

import basic.keywordVisiability.protectedTest.p3.MyObject3;

/**
 * Created by xjlin on 2018/8/27.
 * 对于(1)而言，clone()ProtectedTest3，因此其可见性为包p33及其子类MyObject3，
 * 而（1）ProtectedTest3，属于同一包，编译通过。
 */
public class ProtectedTest3{
    /**
     * Created by xjlin on 2018/8/27.
     */
        public static void main(String args[]) throws CloneNotSupportedException{
            MyObject3 obj = new MyObject3();
            obj.clone();   // Compile OK     ------（1）
        }
}
