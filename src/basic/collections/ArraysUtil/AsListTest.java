package basic.collections.ArraysUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xjlin on 2018/9/10.
 */
public class AsListTest{
    public static void main(String[] args){
        String[] strings = {"1", "a", "b", "test", "c"};
        List<String> stringList = Arrays.asList(strings);

        System.out.println(stringList);
        System.out.println(stringList.size());

        /**
         * 注意， 转换后的list， 不能像普通list一样进行add， remove操作
         */
//        stringList.add("xjlin"); //运行时报错： UnsupportedOperationException
//        System.out.println(stringList);


        //注意以下两种方式， 如果是基本数据， 用Arrays.asList()的时候， 要用包装类
        int[] intArr2 = {1,2,3,4,5};
        List list2 = Arrays.asList(intArr2); //相当于List<int[]> list2 = Arrays.asList(intArr2);
        System.out.println(list2);  //一个地址：[[I@3764951d]
        System.out.println(list2.size()); //1

        Integer[] intArr = {1,2,3,4,5};
        List<Integer> list3 = Arrays.asList(intArr);
        System.out.println(list3);//[1, 2, 3, 4, 5]
        System.out.println(list3.size());//5
    }
}
