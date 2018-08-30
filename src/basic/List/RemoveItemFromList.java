package basic.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xjlin on 2018/5/29.
 */
public class RemoveItemFromList{
    public static void main(String[] args){
        List<Father> fathers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Father father = new Father();
            father.setName(i+"");
            fathers.add(father);
        }

        Iterator<Father> it = fathers.iterator();
        while(it.hasNext()){
            Father x = it.next();
            if(x.getName().equals("5")){
                it.remove();
            }
        }

//
//        for(Father father: fathers) {
//            if(father.getName().equals("5")) {
//                fathers.remove(father);
//            }
//        }

        for(Father father: fathers) {
            System.out.println(father.getName());
        }
    }
}

class Father{
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
