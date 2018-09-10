package basic.collections.List;

/**
 * Created by xjlin on 2017/6/1.
 */

import org.apache.commons.beanutils.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListToMap {
    public static class DemoClass{
        private Integer id;
        private String name;
        public DemoClass(){}
        public DemoClass(Integer id, String name) {
            super();
            this.id = id;
            this.name = name;
        }
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * 版本一：我们写这个方法的时候无法获得bean的get方法，首先想到使用内省机制去实现，commons-beanutils提供了获得属性名对应的
     * get方法，代码如下
     * 经测试（main方法里面的时间是测试结果）：效率很低，多次调用了beanUtils.getProperty严重降低了方法的效率。因此需要找一个
     * 替代的方法，比如直接获得get方法，因此版本二诞生了。
     * @param list
     * @param fieldName4Key
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> list2Map1(List<V> list, String fieldName4Key) {
        Map<K, V> map = new HashMap<K, V>();
        if (list != null) {
            try {
                for (int i = 0; i < list.size(); i++) {
                    V value = list.get(i);
                    @SuppressWarnings("unchecked")
                    K k = (K) BeanUtils.getProperty(value, fieldName4Key);
                    map.put(k, value);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("field can't match the key!");
            }
        }

        return map;
    }
    /**
     * 版本二： 测试结果比较满意，效率上与一般的转换方式差距不大。
     * transfer list into map
     * @param list
     * @param fieldName4Key
     * @return map
     *
     * @author sherlock
     * @date 2016-9-16 12:58:53
     */
    public static <K, V> Map<K, V> list2Map2(List<V> list, String fieldName4Key,Class<V> c) {
        Map<K, V> map = new HashMap<K, V>();
        if (list != null) {
            try {
                PropertyDescriptor propDesc = new PropertyDescriptor(fieldName4Key, c);
                Method methodGetKey = propDesc.getReadMethod();
                for (int i = 0; i < list.size(); i++) {
                    V value = list.get(i);
                    @SuppressWarnings("unchecked")
                    K key = (K) methodGetKey.invoke(list.get(i));
                    map.put(key, value);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("field can't match the key!");
            }
        }

        return map;
    }

    /**
     * 版本3： 也可以通过方法名获得method，因为它们都是先获得方法，效率区别不大，优点是当你需要复杂的规则去组成key
     * 或者value的时候，可以调用自定义的方法，更加灵活，示例代码
     * @param list
     * @param keyMethodName
     * @param c
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> list2Map3(List<V> list, String keyMethodName,Class<V> c) {
        Map<K, V> map = new HashMap<K, V>();
        if (list != null) {
            try {
                Method methodGetKey = c.getMethod(keyMethodName);
                for (int i = 0; i < list.size(); i++) {
                    V value = list.get(i);
                    @SuppressWarnings("unchecked")
                    K key = (K) methodGetKey.invoke(list.get(i));
                    map.put(key, value);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("field can't match the key!");
            }
        }

        return map;
    }

    public static Map<Integer, DemoClass> traditionalWay(List<DemoClass> list) {
        Map<Integer, DemoClass> map = new HashMap<Integer, DemoClass>();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                DemoClass value = list.get(i);
                map.put(value.getId(), value);
            }
        }

        return map;
    }
    public static void main(String[] args) throws Exception{
        List<DemoClass> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(new DemoClass(i,"aaa"));
        }
        long start1 = System.nanoTime();
        //list2Map1(list,"id");  //2265651285
        list2Map2(list,"id",DemoClass.class); //95193405
        //list2Map3(list,"getId",DemoClass.class);
        //Map<Integer,DemoClass> map = traditionalWay(list); //75825131
        long end1 = System.nanoTime();

        System.out.println(end1 - start1);
    }
}