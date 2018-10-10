package basic.collections.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xjlin on 2018/9/12.
 * 测试map中的list变化情况
 *
 * 事实表明， map中存的是地址， 里头的元素变化了， map中取出的东西也会变化
 */
public class MapTest1{
    public static void main(String[] args){
        Map<Integer, Test> a = new HashMap<>();
        Test test = new Test(1, "3");

        a.put(test.getAnInt(), test);

        test.setB("4");

        Test test2 = a.get(1);
        String result = test2.getB();
        System.out.println(result);


    }


}

class Test{
    int anInt;
    String b;

    Test(int anInt, String b){
        this.anInt = anInt;
        this.b = b;
    }

    public int getAnInt(){
        return anInt;
    }

    public void setAnInt(int anInt){
        this.anInt = anInt;
    }

    public String getB(){
        return b;
    }

    public void setB(String b){
        this.b = b;
    }
}
