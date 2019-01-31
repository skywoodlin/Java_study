package medium.thread.线程安全问题;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by xjlin on 2019/1/31.
 *
 * 本程序展示了ArrayList的线程安全问题，
 * 以及如何避免这些问题
 * 一共四个程序， 建议都看一遍
 *
 */
public class ArrayListThreadSafeTest{
    @Test
    /**
     * 非线程安全场景展示
     * Java中 i++ 并非线程安全的，这样多个线程同时往一个ArrayList中加元素，导致元素丢失，
     * 出现空洞。那么如果想在多线程环境中使用ArrayList，有哪些保证其线程安全性的方法呢？
     *
     * 看useSynchronized()方法
     */
    public void notThreadSafe() throws Exception {
        final List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        list.add(new Random().nextInt(100));
                    }
                }
            }).start();

        }

        Thread.sleep(1000 * 3);

        System.out.println("size = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                System.out.println("ERROR===================");
            }
        }
        System.out.println("OVER========================");
    }

    /**
     * 线程安全了, 但是在根据文档：
     * 当我们要迭代 Collections.synchronizedList() 返回的列表时，必须手动同步：看下一个函数：iterWithLock
     *
     * @throws Exception
     */
    @Test
    public void useSynchronized() throws Exception {
        final List<Integer> list = Collections.synchronizedList(Lists.newArrayList());
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        list.add(new Random().nextInt(100));
                    }
                }
            }).start();

        }

        Thread.sleep(1000 * 5);

        /**
         * 输出：结论， 这样就没有线程安全问题了
         * size = 4000
         * OVER========================
         */
        System.out.println("size = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                System.out.println("ERROR===================");
            }
        }
        System.out.println("OVER========================");
    }

    /**
     * 迭代取出synchronizedList必须像如下所写
     */
    @Test
    public void iterWithLock() {
        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        list.add("apple");
        list.add("mi");
        list.add("huawei");

        synchronized (list) {
            Iterator it = list.iterator();
            while (it.hasNext())
                System.out.println(it.next());
        }
    }


    /**
     * Copy On Write 也是一种重要的思想，在写少读多的场景下，为了保证集合的线程安全性，我们完全可以在当前线程中得到原始数据的一份拷贝，然后进行操作。
     * JDK集合框架中为我们提供了 ArrayList 的这样一个实现：CopyOnWriteArrayList。但是如果不是写少读多的场景，
     * 使用 CopyOnWriteArrayList 开销比较大，因为每次对其更新操作（add/set/remove）都会做一次数组拷贝。
     * @throws Exception
     */
    @Test
    public void useCOW() throws Exception {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        list.add(String.format("T%s-%s",Thread.currentThread().getId(), j));
                    }
                }
            }).start();

        }

        Thread.sleep(1000 * 3);
        System.out.println("size = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if (list.get(i) == null) {
                System.out.println("ERROR===================");
            }
        }
        System.out.println("OVER========================");
    }
}
