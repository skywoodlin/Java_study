package basic.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xjlin on 2017/1/19.
 */
public class SortList {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();

        /*stringList.add("v1.1");
        stringList.add("v1.111");
        stringList.add("v1.101");
        stringList.add("v0.1");
        stringList.add("v0.33");
        stringList.add("v2.33");
        stringList.add("v3.33");


        Collections.sort(stringList);
        for (int i = 0; i < stringList.size() ; i++) {
            System.out.println(stringList.get(i));
        }*/

        List<String> stringList2 = new ArrayList<String>();
        stringList2.add("2017-01-04");
        stringList2.add("2005-01-04");
        stringList2.add("2016-01-04");
        stringList2.add("2013-01-04");
        stringList2.add("2027-01-04");
        Collections.sort(stringList2);
        for (int i = 0; i < stringList2.size() ; i++) {
            System.out.println(stringList2.get(i));
        }

        if(stringList2.contains("2027-01-04")) {
            System.out.println("contain");
        }

    }



}
