package medium.ThreadLocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xjlin on 2018/12/14.
 * 模拟一个ThreadLocal方法
 *
 */
public class MyThreadLocal {

    private Map valueMap = Collections.synchronizedMap(new HashMap());
//    private Map<Thread, Object> valueMap2 = Collections.synchronizedMap(new HashMap<>()); //模拟

    public void set(Object newValue) {
        //Key为线程对象，Value为本线程的变量副本
        valueMap.put(Thread.currentThread(), newValue);
//        valueMap2.put(Thread.currentThread(), newValue);

    }

    public Object get() {

        Thread currentThread = Thread.currentThread();
        // 返回当前线程对应的变量
        Object o = valueMap.get(currentThread);
        // 如果当前线程在Map中不存在，则将当前线程存储到Map中
        if (o == null && !valueMap.containsKey(currentThread)) {
            o = initialValue();
            valueMap.put(currentThread, o);
        }
        return o;
    }

    public void remove() {
        valueMap.remove(Thread.currentThread());
    }

    public Object initialValue() {
        return null;
    }
}
