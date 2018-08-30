package medium.VariableParameter;

/**
 * Created by xjlin on 2017/3/14.
 * 接收参数的时候，个数是不定的
 */
public class TestVarArgus {
    public static void dealArray(int... intArray){
        for (int i : intArray)
            System.out.print(i +" ");

        System.out.println();
    }

    /**
     * 以下代码段与上面代码段共存的话会有Duplicate method
     * dealArray(int[]) in type TestVarArgus的错误
     * @param intArray
     * 说明：看到这里估计都能明白，这个不定长的参数其实和数组参数挺像的。事实上，也确实是这么回事儿。
     * 编译器会在悄悄地把这最后一个形参转化为一个数组形参
     */
/*    public static void dealArray(int[] intArray){
        for (int i : intArray)
            System.out.print(i +" ");

        System.out.println();
    }*/


    /**
     * 输出： 1
            1 2 3
     * @param args
     */
    public static void main(String args[]){
        dealArray();
        dealArray(1);
        dealArray(1, 2, 3);
    }


}
