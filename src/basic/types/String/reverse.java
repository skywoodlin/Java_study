package basic.types.String;

/**
 * Created by xjlin on 2018/9/6.
 */
public class reverse{
    public static void main(String[] args){
        String a = "asdfasdfasdf";
        StringBuilder b = new StringBuilder(a).reverse();
        System.out.println(b.toString());

        StringBuffer c = new StringBuffer(a).reverse();
        System.out.println(c);
    }
}
