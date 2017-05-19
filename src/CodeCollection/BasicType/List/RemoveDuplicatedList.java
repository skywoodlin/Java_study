package CodeCollection.BasicType.List;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by xjlin on 2017/5/10.
 */
public class RemoveDuplicatedList {

    /**
     * List去重
     *
     * @param list
     */
    private static void removeDuplicateRecordsFromList(ArrayList list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            Object element = iter.next();
            if (set.add(element)) {
                newList.add(element);
            }
        }
        list.clear();
        list.addAll(newList);
    }

    /** List order not maintained **/
    public  static void removeDuplicateRecordsFromList2(ArrayList arlList)
    {
        HashSet h = new HashSet(arlList);
        arlList.clear();
        arlList.addAll(h);
    }
}
