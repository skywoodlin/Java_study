package basic.collections.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xjlin on 2018/9/10.
 */
public class MapDemo1{
    public static void main(String[] args){
        Map<Integer, String> map = new HashMap<>();
        methodMemo(map);
    }

    public static void methodMemo(Map<Integer, String>map) {
        //1. 存储
        map.put(1, "xiaoqiang1");
        map.put(2, "xiaoqiang2");
        map.put(3, "xiaoqiang3");
        map.put(4, "xiaoqiang4");
        System.out.println(map.put(5, "xiaoqiang5")); //null, 返回与key相对应的旧值
        System.out.println(map.put(5, "xiaoqiang6")); //xiaoqiang5
        System.out.println(map.get(5)); //xiaoqiang6

        System.out.println(map);
    }
}
