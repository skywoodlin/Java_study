package basic.ToHex;

/**
 * Created by xjlin on 2018/9/6.
 */
public class ToHex{
    public static void main(String[] args){
        System.out.println(Double.toHexString(11.11));
        System.out.println(Float.toHexString(11.11f));
        System.out.println(Integer.toHexString(-1));
        System.out.println(Integer.toBinaryString(-1));
        Integer a = -1;
        System.out.println(a.byteValue());
    }
}
