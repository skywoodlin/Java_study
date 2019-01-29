package utils;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xjlin on 2018/11/26.
 */
public class RegexUtils{
    private static final String PATTERN_1 = "<_&tag$_\\s[\\s\\S]+?</_&tag$_>";
    private static final String PATTERN_2 = "^.*\\\\";
    private static final String PATTERN_3 = "[^\\\\]*$";
    private static final String PATTERN_4 = "^[1-9]\\d{14}(\\d{2}[0-9x])?$"; //身份证
    private static final String PATTERN_7 = "^([1-9]\\d{14}|[1-9]\\d{16}[0-9x])$"; //身份证(多选结构)
    private static final String PATTERN_5 = "^\\d{13}(\\d{3})?$"; //13个数字或者16个数字
    private static final String PATTERN_6 = "^[-\\w.]{0,64}@([-a-zA-Z0-9]{1,63}\\.)*[-a-zA-Z0-9]{1,63}$"; //email

    private static final String PATTERN_8 = "^([0-9]|[0-9]{2}|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$"; //匹配0~255之间的字符串
    private static final String PATTERN_9 = "^(([0-9]|[0-9]{2}|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}" +
            "([0-9]|[0-9]{2}|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$"; //匹配ip地址

    /**
     * 从windows上的全路径分离出目录
     *
     * @param fullPath
     * @return
     */
    public static String getPathFromFullPathForWindows(String fullPath){
        Pattern pattern = Pattern.compile(PATTERN_2);
        Matcher matcher = pattern.matcher(fullPath);
        if(matcher.find()){
            return matcher.group();
        }else{
            return "";
        }
    }

    /**
     * 从windows上的全路径分离出文件名
     *
     * @param fullPath
     * @return
     */
    public static String getfileNameFromFullPathForWindows(String fullPath){
        Pattern pattern = Pattern.compile(PATTERN_3);
        Matcher matcher = pattern.matcher(fullPath);
        if(matcher.find()){
            return matcher.group();
        }else{
            return "";
        }
    }


    /**
     * 取出text中以<tag></tag>为标签， 并且有属性（例如<tag abc="dd"> kkkk</tag>）的内容
     *
     * @param text 传入的文本
     * @param tag  传入的标签字符串，
     * @return
     */
    public static String[] findTags(String text, String tag){
        List<String> resultList = new ArrayList<>();
        String patternStr = PATTERN_1.replace("_&tag$_", tag);
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            resultList.add(matcher.group());
        }
        String[] result = null;
        if(resultList.size() != 0){
            result = new String[resultList.size()];
            resultList.toArray(result);
        }

        return result;
    }

    /**
     * 验证是否是合法的中国身份证号， 规则
     * 1. 首位是0~9的数字
     * 2. 如果是15位身份证， 全部是数字
     * 3. 如果是18位， 最后一位可能是X
     * @param idCardNum
     * @return
     */
    public static boolean isValidIdCardNum(String idCardNum) {
        if(StringUtils.isNotEmpty(idCardNum)) {
            return idCardNum.matches(PATTERN_4);
        }
        return false;
    }

    /**
     * 方法2
     * 验证是否是合法的中国身份证号， 规则
     * 1. 首位是0~9的数字
     * 2. 如果是15位身份证， 全部是数字
     * 3. 如果是18位， 最后一位可能是X
     * @param idCardNum
     * @return
     */
    public static boolean isValidIdCardNum2(String idCardNum) {
        if(StringUtils.isNotEmpty(idCardNum)) {
            return idCardNum.matches(PATTERN_7);
        }
        return false;
    }


    /**
     * 是否是13个数字或者16个数字组成的字符串
     * @param str
     * @return
     */
    public static boolean isString13or16Char(String str) {
        if(StringUtils.isNotEmpty(str)) {
            return str.matches(PATTERN_5);
        }
        return false;
    }

    /**
     * 验证是否是一个合法的email
     * @param str
     * @return
     */
    public static boolean isEmail(String str) {
        if(StringUtils.isNotEmpty(str)) {
            return str.matches(PATTERN_6);
        }
        return false;
    }

    /**
     * 匹配0~255之间的字符串
     * @param str
     * @return
     */
    public static boolean isBetween0And255(String str) {
        if(StringUtils.isNotEmpty(str)) {
            return str.matches(PATTERN_8);
        }
        return false;
    }

    /**
     * 匹配ip地址
     * @param str
     * @return
     */
    public static boolean isIPAddress(String str) {
        if(StringUtils.isNotEmpty(str)) {
            return str.matches(PATTERN_9);
        }
        return false;
    }

}
