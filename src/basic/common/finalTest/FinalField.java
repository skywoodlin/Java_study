package basic.common.finalTest;

/**
 * Created by xjlin on 2018/9/3.
 */
public class FinalField{
    private final int anInt;
//    {
//        anInt = 3;
//    }

    FinalField(int n) {
        anInt = n;
    }


    public int getAnInt(){
        return anInt;
    }

    public void test() {
//        anInt = 1; //编译不过
    }
}
