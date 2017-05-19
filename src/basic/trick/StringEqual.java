package basic.trick;

/**
 * Created by xjlin on 2017/3/15.
 * 结果： true, false
 * 解释： String是一 个特殊的包装类数据。可以用：
 String str = new String("abc");
 String str = "abc";
 两种的形式来创建，第一种是用new()来新 建对象的，它会在存放于堆中。每调用一次就会创建一个新的对象。

 而第二种（String str = "abc";）是先在栈中创建一个对String类的对象引用变量str，然后查找栈 中有没有存放"abc"，
 如果没有，则将"abc"存放进栈，并令str指向”abc”，如果已经有”abc” 则直接令str指向“abc”。
 */
public class StringEqual {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1==str2); //true

        String str3 =new String ("abc");
        String str4 =new String ("abc");
        System.out.println(str3 == str4); // false
    }
}
