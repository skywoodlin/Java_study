package medium.Regex;

import java.util.regex.Pattern;

/**
 * Created by xjlin on 2018/11/21.
 */
public class RegexTest2{
    public static void main(String[] args){
//        Pattern p= Pattern.compile("\\w+");
//        p.pattern();//返回 \w+
//        System.out.println(p.pattern());
        String PARAM_TYPE_REGEX = "\\(\\D{3,30}?\\),{0,1}";
        String str1 = "123(Integer), world(String)";
        String[] arr = str1.split(PARAM_TYPE_REGEX);
        for(String str: arr) {
            System.out.println(str);
        }

    }
}
