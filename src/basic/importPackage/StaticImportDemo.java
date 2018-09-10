package basic.importPackage;

/**
 * Created by xjlin on 2018/9/10.
 */
import java.util.*;
import static java.util.Collections.*;
import static java.lang.System.*;
public class StaticImportDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {


        List<String> list  = new ArrayList<String>();
        list.add("a");
        list.add("c");

        sort(list);

//		System.out.println(max(list));
        out.println("hello");
    }

}
