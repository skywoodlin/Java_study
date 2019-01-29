package medium.Regex.testForChinesBook;

/**
 * Created by xjlin on 2018/11/22.
 */
public class RegexBasicTest{
    public static void main(String[] args){
        boolean a = "1".matches("^\\d$"); //true
        System.out.println(a);

        boolean b = "1a".matches("^\\d$"); //false
        System.out.println(b);

        System.out.println("你".matches("^.$")); //true   .可以匹配中文字符

        System.out.println("55".matches("^[0-9]$")); //false  只能匹配一个字符

        System.out.println("9".matches("^[3\\-8]")); //双斜杠是因为字符串本身的转义！ false  只能匹配，3， -， 8


        /**
         * 如果出现"]"， 会找她之前的最近的"["， 如果找不到，
         * 说明它不是特殊字符， 就当“]”看待，所以不管怎样"]"都不需要转义？（待验证）
         */
        System.out.println("]测试-------------------------------------");
        System.out.println("]".matches("]")); //true
        System.out.println("]".matches("\\[]")); //true
        System.out.println("]".matches("[\\[]]")); //false
        System.out.println("[]".matches("[\\[]]")); //true
        System.out.println("[]".matches("[\\[]\\]")); //true 后面两个斜杆没必要

        /**
         * 注： 排除型字符组必须匹配一个字符， 不能为空
         */
        System.out.println("排除型字符组-------------------------------");
        System.out.println("A8".matches("^[^0-9][0-9]$")); //true
        System.out.println("8".matches("^[^0-9][0-9]$")); //false

        System.out.println("-".matches("^[^-89]$")); //false  非-， 8， 9
        System.out.println("1".matches("^[^-89]$")); //true  非-， 8， 9

        /**
         * 测试字符组简写法
         * \d: [0-9]
         * \w: [0-9a-zA-Z]: word:单词字符， 不包括其它符号什么的
         * \s: [\t\r\n\v\f]  : 空白符， 分别代表space，回车（return）， tab， 换行， \f换页符
         *
         */
        System.out.println("字符组简写法-------------------------------");
        System.out.println("8".matches("^\\d$"));  //true
        System.out.println("s".matches("^\\d$"));  //false

        System.out.println("B".matches("^\\w$"));  //true
        System.out.println("@".matches("^\\w$"));  //false

        System.out.println(" ".matches("^\\s$"));  //true
        System.out.println("\n".matches("^\\s{1,5}$"));  //true
        System.out.println("\n\t".matches("^\\s{1,5}$"));  //true
        System.out.println("\n\t\r".matches("^\\s{1,5}$"));  //true
        System.out.println("\n\t\r\f".matches("^\\s{1,5}$"));  //true

        /**
         * "."匹配任意字符？ 事实上， 它不能匹配换行符
         * 果然是！！
         */
        System.out.println("\".\"号不能匹配换行符---------------------------");
        System.out.println(" ".matches("."));  //true
        System.out.println("&".matches("."));  //true
        System.out.println("\t".matches("."));  //true
        System.out.println("\n".matches("."));  //false

        /**
         * 如何匹配任意字符
         * [\w\W]  或者
         * [\s\S]  或者
         * [\d\D]
         */
        System.out.println("如何匹配任意字符----------------------------------");
        System.out.println("\n".matches("^[\\d\\D]$"));  //true
        System.out.println("\n".matches("^[\\s\\S]$"));  //true
        System.out.println("\n".matches("^[\\w\\W]$"));  //true







    }
}
