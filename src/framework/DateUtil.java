package framework;
import java.util.regex.Pattern;

/**
 * Created by xjlin on 2017/6/4.
 * 不推荐直接使用,推荐使用com.onlyou.framework.base.utils.DateUtils
 *
 * @author xjlin
 */
@Deprecated
public class DateUtil {

    /**
     * 匹配 yyyy-MM-dd 的正则,包括闰年
     */
    public static final String yyyy_MM_dd_REG_EXP = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\-\\s]?((((0?[13578])|(1[02]))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\-\\s]?((((0?[13578])|(1[02]))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\-\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";

    /**
     * 匹配 yyyy-MM-dd HH:mm:ss 的正则,包括闰年
     */
    public static final String yyyy_MM_dd_HH_mm_ss_REG_EXP = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";

    /**
     * 匹配 dd/MM/yyyy 的正则,包括闰年
     */
    public static final String dd_MM_yyyy_REG_EXP = "^((((((0?[1-9])|([1-2][0-9])|(3[01]))[\\\\/\\\\s]?((0?[13578])|(1[02])))|(((0?[1-9])|([1-2][0-9])|(30))[\\\\/\\\\s]?((0?[469])|(11)))|(((0?[1-9])|([1-2][0-9]))[\\\\/\\\\s]?0?2))[\\\\/\\\\s]?\\d{2}(([02468][048])|([13579][26])))|(((((0?[1-9])|([1-2][0-9])|(3[01]))[\\\\/\\\\s]?((0?[13578])|(1[02])))|(((0?[1-9])|([1-2][0-9])|(30))[\\\\/\\\\s]?((0?[469])|(11)))|(((0?[1-9])|(1[0-9])|(2[0-8]))[\\\\/\\\\s]?0?2))[\\\\/\\\\s]?\\d{2}(([02468][1235679])|([13579][01345789]))))";

    /**
     * 匹配 dd/MM/yyyy HH:mm:ss 的正则,包括闰年
     */
    public static final String dd_MM_yyyy_HH_mm_ss_REG_EXP = "^((((((0?[1-9])|([1-2][0-9])|(3[01]))[\\\\/\\\\s]?((0?[13578])|(1[02])))|(((0?[1-9])|([1-2][0-9])|(30))[\\\\/\\\\s]?((0?[469])|(11)))|(((0?[1-9])|([1-2][0-9]))[\\\\/\\\\s]?0?2))[\\\\/\\\\s]?\\d{2}(([02468][048])|([13579][26])))|(((((0?[1-9])|([1-2][0-9])|(3[01]))[\\\\/\\\\s]?((0?[13578])|(1[02])))|(((0?[1-9])|([1-2][0-9])|(30))[\\\\/\\\\s]?((0?[469])|(11)))|(((0?[1-9])|(1[0-9])|(2[0-8]))[\\\\/\\\\s]?0?2))[\\\\/\\\\s]?\\d{2}(([02468][1235679])|([13579][01345789]))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";

    /**
     * 日期 格式 yyyy-MM-dd
     */
    public static final String yyyy_MM_dd = "yyyy-MM-dd";

    /**
     * 日期时分秒 格式 yyyy-MM-dd HH:mm:ss
     */
    public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期 格式 dd/MM/yyyy
     */
    public static final String dd_MM_yyyy = "dd/MM/yyyy";

    /**
     * 日期时分秒 格式 dd/MM/yyyy HH:mm:ss
     */
    public static final String dd_MM_yyyy_HH_mm_ss = "dd/MM/yyyy HH:mm:ss";

    /**
     * (包括闰年)正则判断是否为 yyyy-MM-dd 格式的字符
     *
     * @param dateString yyyy-MM-dd 格式字符
     * @return
     */
    public static boolean isDateString(String dateString) {
        Pattern p = Pattern.compile(yyyy_MM_dd_REG_EXP);
        //匹配格式
        return p.matcher(dateString).matches();
    }

    /**
     * (包括闰年)正则判断是否为 yyyy-MM-dd hh:mm:ss 格式的字符
     *
     * @param dateTimeString yyyy-MM-dd hh:mm:ss 格式字符
     * @return
     */
    public static boolean isDateTimeString(String dateTimeString) {
        Pattern p = Pattern.compile(yyyy_MM_dd_HH_mm_ss_REG_EXP);
        //匹配格式
        return p.matcher(dateTimeString).matches();
    }

    /**
     * (包括闰年)正则判断是否为 dd/MM/yyyy 格式的字符
     *
     * @param dateString dd/MM/yyyy 格式字符
     * @return
     */
    public static boolean isDateString2(String dateString) {
        Pattern p = Pattern.compile(dd_MM_yyyy_REG_EXP);
        //匹配格式
        return p.matcher(dateString).matches();
    }

    /**
     * (包括闰年)正则判断是否为 dd/MM/yyyy hh:mm:ss 格式的字符
     *
     * @param dateTimeString dd/MM/yyyy hh:mm:ss 格式字符
     * @return
     */
    public static boolean isDateTimeString2(String dateTimeString) {
        Pattern p = Pattern.compile(dd_MM_yyyy_HH_mm_ss_REG_EXP);
        //匹配格式
        return p.matcher(dateTimeString).matches();
    }
}
