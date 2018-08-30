package basic.keywordVisiability.protectedTest.p22;

import basic.keywordVisiability.protectedTest.p2.MyObject2;

/**
 * Created by xjlin on 2018/8/27.
 * 对于(1)而言，clone()方法来自于类MyObject2本身，因此其可见性为包p2及MyObject2的子类，
 * 虽然ProtectedTest2是MyObject2的子类,但在ProtectedTest2中不能访问基类MyObject2的protected方法clone()，
 * 因此编译不通过;对于(2)而言，
 * 由于在ProtectedTest2中访问的是其本身实例的从基类MyObject2继承来的的clone()，因此编译通过。
 */
public class ProtectedTest2 extends MyObject2{
    public static void main (String args[]) throws CloneNotSupportedException{
        MyObject2 obj = new MyObject2();
//        obj.clone(); // Compile Error         ----（1）

        ProtectedTest2 tobj = new ProtectedTest2();
        tobj.clone(); // Complie OK         ----（2）
    }
}
