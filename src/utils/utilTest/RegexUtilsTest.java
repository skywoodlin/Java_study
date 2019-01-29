package utils.utilTest;

import org.junit.Test;
import utils.RegexUtils;

/**
 * Created by xjlin on 2018/11/26.
 */
public class RegexUtilsTest{
    @Test
    public void testIdCardNum() {
        //测试完全通过
        System.out.println(RegexUtils.isValidIdCardNum("350403198307181019"));
        System.out.println(RegexUtils.isValidIdCardNum("3504031983081019"));
        System.out.println(RegexUtils.isValidIdCardNum("350403198307119"));
        System.out.println(RegexUtils.isValidIdCardNum("35040319830711x"));
        System.out.println(RegexUtils.isValidIdCardNum("35040319830711912x"));


        System.out.println(RegexUtils.isValidIdCardNum2("350403198307181019"));
        System.out.println(RegexUtils.isValidIdCardNum2("3504031983081019"));
        System.out.println(RegexUtils.isValidIdCardNum2("350403198307119"));
        System.out.println(RegexUtils.isValidIdCardNum2("35040319830711x"));
        System.out.println(RegexUtils.isValidIdCardNum2("35040319830711912x"));
    }

    @Test
    public void test13or16Char() {
        System.out.println(RegexUtils.isString13or16Char("1234"));
        System.out.println(RegexUtils.isString13or16Char("1234567890123"));
        System.out.println(RegexUtils.isString13or16Char("12345678901234"));
        System.out.println(RegexUtils.isString13or16Char("1234567x90123"));
        System.out.println(RegexUtils.isString13or16Char("1234567890123123"));
    }

    @Test
    public void testEmail() {
        System.out.println(RegexUtils.isEmail("skywood.lin@gmail.com"));
        System.out.println(RegexUtils.isEmail("skywood.lin@gmail"));
        System.out.println(RegexUtils.isEmail("skywood.lin@m-s.gmail.com"));
        System.out.println(RegexUtils.isEmail("skywood.lin@m-s.gmail.info"));


        System.out.println(RegexUtils.isEmail("skywood.lin@.gmail.com"));
        System.out.println(RegexUtils.isEmail("skywood#lin@gmail.com"));
    }

    @Test
    public void testBetween0And255() {
        System.out.println(RegexUtils.isBetween0And255("0"));
        System.out.println(RegexUtils.isBetween0And255("254"));
        System.out.println(RegexUtils.isBetween0And255("255"));
        System.out.println(RegexUtils.isBetween0And255("198"));
        System.out.println(RegexUtils.isBetween0And255("256"));
    }

    @Test
    public void testIPAddress() {
        //完全通过
        System.out.println(RegexUtils.isIPAddress("255.0.0.1"));
        System.out.println(RegexUtils.isIPAddress("255.0.0"));
        System.out.println(RegexUtils.isIPAddress("255.255"));
        System.out.println(RegexUtils.isIPAddress("255.0.0."));
        System.out.println(RegexUtils.isIPAddress("255.0.255.256"));
        System.out.println(RegexUtils.isIPAddress("255.0.255.255"));
        System.out.println(RegexUtils.isIPAddress("255.255.255.255"));
        System.out.println(RegexUtils.isIPAddress("255..255.255"));

    }
}
