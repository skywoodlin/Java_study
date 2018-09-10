package basic.collections.List;

/**
 * Created by xjlin on 2017/12/14.
 */
public class ArrayAndList {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5};

        System.out.println(a);  //地址
        System.out.println(a.toString());  //地址

        a[0] = 2;

        ArrayAndList.pringArray(a);
    }

    public static <T> void pringArray(T[] anArray) {
        if (anArray == null || anArray.length == 0) {
            return;
        }

        for(T element: anArray) {
            System.out.print(element.toString() + ",");
        }
    }


}
