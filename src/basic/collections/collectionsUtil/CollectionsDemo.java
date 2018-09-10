package basic.collections.collectionsUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xjlin on 2018/9/10.
 */
public class CollectionsDemo{
    public static void main(String[] args){
        methodDemo1();
    }

    public static void methodDemo1() {
        List<String> list = new ArrayList<>();

        list.add("abcd");
        list.add("z");
        list.add("hehe");
        list.add("nba");

        System.out.println(list);

        //对list自然排序， 使用的是元素的compareTo方法
        Collections.sort(list);
        System.out.println(list);

        //想按照长度排序
        Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                int temp = o1.length() - o2.length();

                return temp == 0 ? o1.compareTo(o2):temp;
            }
        };

        Collections.sort(list, comparator);
        System.out.println(list);

        //强行逆转比较器
        Collections.sort(list, Collections.reverseOrder(comparator));
        System.out.println(list);






    }
}
