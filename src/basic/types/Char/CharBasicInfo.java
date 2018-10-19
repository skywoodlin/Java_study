package basic.types.Char;

/**
 * Created by xjlin on 2018/10/12.
 */
public class CharBasicInfo{
    public static void main(String[] args){
        String str1 = "Ƶis the set of integers";
        System.out.println(str1.length()); //23 Ƶ算一位长度
        int str1Count =str1.codePointCount(0, str1.length());
        System.out.println(str1Count); //23
        //但是
        char c1 = str1.charAt(0);
        System.out.println(c1); //Ƶ

        char c2 = str1.charAt(1);
        System.out.println(c2); //i

    }
}
