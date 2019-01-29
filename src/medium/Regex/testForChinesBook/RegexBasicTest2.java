package medium.Regex.testForChinesBook;

/**
 * Created by xjlin on 2018/11/23.
 */
public class RegexBasicTest2{
    public static void main(String[] args){
        /**
         * 字符组运算
         */
        //表示非元音字母
        System.out.println("非元音字幕---------------------------------------");
        System.out.println("a".matches("^[a-z&&[^aeiou]]$")); //false
        System.out.println("u".matches("^[a-z&&[^aeiou]]$")); //false
        System.out.println("b".matches("^[a-z&&[^aeiou]]$")); //true
        System.out.println("z".matches("^[a-z&&[^aeiou]]$")); //true


        /**
         * 量词
         */
        System.out.println("量词测试-----------------------------------");
        System.out.println("365001".matches("^\\d{6}$")); //true
        System.out.println("365001".matches("^[\\d]{6}$")); //true
        System.out.println("3650".matches("^[\\d]{5,6}$")); //false
        System.out.println("36501".matches("^[\\d]{5,6}$")); //true

        //只限定下限
        System.out.println("3650111111111111".matches("^[\\d]{5,}$")); //true
        //只限定上线， 推荐0一定要写
        System.out.println("36501".matches("^[\\d]{0,4}$")); //false



        /**
         * 匹配"***", 中间一定要有字符， 并且不能是"\""
         */
        System.out.println("\"abc\"".matches("^\"[^\"]+\""));


    }
}
