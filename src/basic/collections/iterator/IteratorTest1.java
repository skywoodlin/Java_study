package basic.collections.iterator;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by xjlin on 2018/9/7.
 */
public class IteratorTest1{
    public static void main(String[] args){
        Collection collection1 = new ArrayList();
        collection1.add("abc1");
        collection1.add("abc2");
        collection1.add("abc3");
        collection1.add("abc4");

        //迭代器取数方法1
        Iterator it = collection1.iterator();
        while(it.hasNext()) {
            String str = (String)it.next();
            System.out.println(str);
        }

        //迭代器取数方法2, 一般使用这个， 因为在for中是临时的， 结束后便回收， 不会有垃圾
        for(Iterator it2 = collection1.iterator(); it2.hasNext();) {
            System.out.println(it2.next());
        }

    }
}
