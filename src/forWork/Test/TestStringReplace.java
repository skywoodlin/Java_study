package forWork.Test;

/**
 * Created by xjlin on 2017/9/28.
 */
public class TestStringReplace {
    public static void main(String[] args) {
        String dateTmp = "2018/07/18";
        String date= null;
        if(dateTmp.contains("/")) {
            dateTmp = dateTmp.replace("/", "-");
        }
        System.out.println(dateTmp);
    }
}
