package medium;

/**
 * 测试同一个字符串的hashCode是不是一样， 结果是： 一样
 * Created by xjlin on 2017/5/13.
 */
public class HashCodeTest {
    public static void main(String[] args) {
        String a = "123456asdffds";
        String b = "123456asdffds";
        int aHashCode = a.hashCode();
        int bHashCode = b.hashCode();
        System.out.println("a: " + aHashCode);
        System.out.println("b: " + bHashCode);
        System.out.println(aHashCode==bHashCode);

        String c = "123456asdffds";
        String d = new String("123456asdffds");
        int cHashCode = c.hashCode();
        int dHashCode = d.hashCode();
        System.out.println("c: " + cHashCode);
        System.out.println("d: " + dHashCode);
        System.out.println(cHashCode==dHashCode);


    }
}
