package medium.VariableParameter;

/**
 * Created by xjlin on 2017/3/14.
 * 接收参数的时候，个数是不定的
 */
public class TestVarArgus2 {
    public static void dealArray(int[] intArray){
        for (int i : intArray)
            System.out.print(i +" ");

        System.out.println();
    }

    public static void main(String args[]){
//        可变参数是兼容数组类参数的，但是数组类参数却无法兼容可变参数。
// 其实编译器并不知道什么可变不可变，在它看来，
// 需要定义一个dealArray(int, int, int）类的方法。所以，自然就无法去匹配数组类参数的dealArray方法了
//        dealArray(1, 2, 3);  //编译错误
    }
}
