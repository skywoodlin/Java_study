package algorithm.string;

/**
 * Created by xjlin on 2018/9/6.
 * 找到两个字符串中包含的最长的相同字串
 */
public class FindMaxSameStringFromTwoString{
    public static void main(String[] args){
        String a = "abbbbbbbbbbbbbbbbbbbbbb";
        String b = "bbabbdd";
        String result = FindMaxSameStringFromTwoString.getMaxSubString(a,b);
        System.out.println(result);
    }

    public static String getMaxSubString(String s1, String s2){
        String longStr, shortStr;
        longStr = s1.length() > s2.length() ? s1 : s2;
        shortStr = s1.equals(longStr) ? s2 : s1;

        for(int x = 0; x<shortStr.length (); x++) {
            for(int y = 0, z=shortStr.length() -x; z<=shortStr.length(); y++, z++) {
                String temp = shortStr.substring(y,z);
                if(longStr.contains(temp)) {
                    return temp;
                }
            }
        }
        return null;
    }
}
