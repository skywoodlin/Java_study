package basic.collections.Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by xjlin on 2018/9/10.
 */
public class MapDemo2{
    public static void main(String[] args){
        Map<String, String> map = new HashMap<>();
        map.put("a", "xiaojie_a");
        map.put("b", "xiaojie_b");
        map.put("c", "xiaojie_c");
        map.put("d", "xiaojie_d");
        map.put("e", "xiaojie_e");

        System.out.println(map); //{a=xiaojie_a, b=xiaojie_b, c=xiaojie_c, d=xiaojie_d, e=xiaojie_e}


        /**
         * 取出map中的所有元素：
         * 方法一： keySet,取出所有的键，并存储到set集合中。map集合没有迭代器。但是可以将map集合转成set集合，在使用迭代器就OK
         */
        Set<String> keySet = map.keySet(); //因为set中是唯一的， hashMap的key也是唯一的

        for(Iterator<String> it = keySet.iterator(); it.hasNext();) {
            String key = it.next();
            String value = map.get(key);
            System.out.println(key + ": " + value);
        }

        //增强for
        for(String str: keySet) {
            System.out.println(str);
        }

        /**
         * 取出map中的所有元素：entrySet()
         * 方法二： Map.Entry<k,v>
         */
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for(Iterator<Map.Entry<String, String>> it = entrySet.iterator(); it.hasNext();) {
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        /**
         * 演示values()所有值
         * 因为value是可以重复的， 所以返回的是Collection
         *
         */
        Collection<String> values = map.values();
        for(String a: values) {
            System.out.println(a);
        }





    }
}
