package basic.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjlin on 2018/9/10.
 * 集合转数组
 *
 * /*
 * 		 * 传入的的数组长度，如果小于集合长度，方法中会创建一个新的长度和集合长度一致的数组。
 * 		 * 如果传入的数组长度大于等于集合长度，会使用传入的数组。所以建议长度定义为 集合的size();
 * 		 *
 * 		 * 为什么要把集合转成数组。
 * 		 * 就是为了限定对元素的操作，比如增删。， 当然， 改是可以的Array.set(arr, int index, T value)
 *
 * 		 因为array是一个长度限制了的对象
 *
 * 		 *
 *
 */
public class CollectionToArray{
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("haha");
        String [] strArr = new String[list.size()];
        list.toArray(strArr);
        System.out.println(strArr);
    }
}
