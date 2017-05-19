package forWork.Test2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjlin on 2017/4/5.
 */
public class TestList {
    public static void main(String[] args) {
        List<Father> fatherList = new ArrayList<Father>();
        for (int i = 0; i < 10; i++) {
            String tempStr = i+"";

        }
    }
}

class Father {
    Father(String a) {
        this.str1 = a;
    }
    private String str1;

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }
}