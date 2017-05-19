package medium.VariableParameter;

/**
 * Created by xjlin on 2017/3/14.
 * 代码贴出来估计都知道是输出2，而不是1。记住：能匹配定长的方法，
 * 那么优先匹配该方法。含有不定参数的那个重载方法是最后被选中的
 */
public class TestVarArgus4 {
    public static void dealArray(int... intArray){
        System.out.println("1");
    }

    public static void dealArray(int count, int count2){
        System.out.println("2");
    }

    public static void main(String args[]){
        dealArray(1, 2);
    }
}
