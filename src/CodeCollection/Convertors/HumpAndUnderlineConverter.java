package CodeCollection.Convertors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xjlin on 2018/3/14.
 */
public class HumpAndUnderlineConverter {
    private static Pattern linePattern = Pattern.compile("_(\\w)");
    /**下划线转驼峰*/
    public static String lineToHump(String str){
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**驼峰转下划线(简单写法，效率低于{@link #humpToLine2(String)})*/
    public static String humpToLine(String str){
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**驼峰转下划线,效率比上面高*/
    public static String humpToLine2(String str){
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, "_"+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        String lineToHump = lineToHump("reimbursement_no");
        String lineToHump1 = lineToHump("name");
        String lineToHump2 = lineToHump("remark");
        String lineToHump3 = lineToHump("food_allowance");
        String lineToHump4 = lineToHump("meeting_fee");
        String lineToHump5 = lineToHump("driver_allowance");
        String lineToHump6 = lineToHump("plane_fee");
        String lineToHump7 = lineToHump("train_fee");
        String lineToHump8 = lineToHump("bus_fee");
        String lineToHump9 = lineToHump("taxi_fee");
        System.out.println(lineToHump);//fParentNoLeader
        System.out.println(lineToHump1);//fParentNoLeader
        System.out.println(lineToHump2);//fParentNoLeader
        System.out.println(lineToHump3);//fParentNoLeader
        System.out.println(lineToHump4);//fParentNoLeader
        System.out.println(lineToHump5);//fParentNoLeader
        System.out.println(lineToHump6);//fParentNoLeader
        System.out.println(lineToHump7);//fParentNoLeader
        System.out.println(lineToHump8);//fParentNoLeader
        System.out.println(lineToHump9);//fParentNoLeader
//        System.out.println(humpToLine(lineToHump));//f_parent_no_leader
//        System.out.println(humpToLine2(lineToHump));//f_parent_no_leader
    }
}

