package utils.utilTest;

import static utils.StringUtils.StrToBool;

/**
 * Created by xjlin on 2018/10/12.
 */
public class StringUtilsTest{
    public static void main(String[] args){
        boolean[] booleans = StrToBool("love");
        for(boolean b: booleans) {
            System.out.println(b);
        }
    }
}