package medium.Regex.testForChinesBook;

import basic.importPackage.StaticImportDemo;

/**
 * Created by xjlin on 2018/11/23.
 */
public class HtmlTagTest{
    private static final String OPENTAGREG = "^<[^/]([^>]*[^/])?>$";


    public static void main(String[] args){
        /**
         * 匹配<****>, 中间一定要有字符， 并且不能是">"
         */
        System.out.println("标准tag: <...>------------------------------");
        System.out.println("<html>".matches("^<[^>]+>$")); //true
        System.out.println("<>".matches("^<[^>]+>$")); //false
        System.out.println("<>>".matches("^<[^>]+>$")); //false

        /**
         * 正则指引， P36, pdf P57
         * opentag:^<[^/]([^>]*[^/])?>$
         */
        System.out.println("open tag: <...>----------------------------------");
        System.out.println("<abc>".matches(OPENTAGREG)); //true
        System.out.println("</abc>".matches(OPENTAGREG)); //false
        System.out.println("<a>bc>".matches(OPENTAGREG)); //false

        /**
         * close tag:^</[^>]+>$
         */
        System.out.println("close tag: <...>----------------------------------");
        System.out.println("<abc>".matches("^</[^>]+>$")); //false
        System.out.println("</abc>".matches("^</[^>]+>$")); //true
        System.out.println("</a>bc>".matches("^</[^>]+>$")); //false

        /**
         *  self-closing tag
         *  <test/>: ^<[^/]+/>$
         */
        System.out.println("self-closing tag: <.../>----------------------------");
        System.out.println("<abc>".matches("^<[^/]+/>$"));  //false
        System.out.println("<abc />".matches("^<[^/]+/>$"));//true
        System.out.println("<abc>/>".matches("^<[^/]+/>$"));//true

        /**
         * 匹配所有的有效的a标签（必须有属性的， 没有属性怎么叫a标签）
         */

    }
}
