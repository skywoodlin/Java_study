package basic.List;

import java.util.ArrayList;

/**
 * Created by xjlin on 2018/7/19.
 */
public class RemoveItemFromArrayListTest1{
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        list.add("4");
        list.add("5");

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        list.remove("3");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
