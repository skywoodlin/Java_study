package basic.Date;

import java.util.Calendar;

/**
 * Created by xjlin on 2017/5/19.
 */
public class CalendarInit {
    public static void main(String[] args) {
        Calendar c1 = Calendar.getInstance();
        c1.set(1983,6,18);
        System.out.println(c1.get(Calendar.DAY_OF_WEEK));
    }
}
