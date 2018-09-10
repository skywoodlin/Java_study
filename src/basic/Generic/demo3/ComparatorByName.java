package basic.Generic.demo3;

import java.util.Comparator;

/**
 * Created by xjlin on 2018/9/10.
 */
public class ComparatorByName implements Comparator<PersonForGenericDemo3> {
    @Override
    public int compare(PersonForGenericDemo3 o1, PersonForGenericDemo3 o2){
        int temp = o1.getName().compareTo(o2.getName());
        return temp == 0 ? o1.getAge() - o2.getAge() : temp;
    }
}
