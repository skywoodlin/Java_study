package CodeCollection.ForWork;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据月份期间（"2015-07", "2017-12"）
 * 生成ArrayList<String>["2015-07", "2015-08", ..., "2017-12"]
 * Created by xjlin on 2017/6/23.
 */
public class ExactMonthListFromMonthString {
    public static void main(String[] args) {
        ExactMonthListFromMonthString test = new ExactMonthListFromMonthString();
        List<String> b = test.getMonthListFromPeriod("2015-07", "2015-12");
        System.out.println(b);


    }

    String increaseMonth(String month){
        int currentMonth_int;
        int nextMonth_int;
        if (month.startsWith("0")) {
            currentMonth_int = Integer.parseInt(month.substring(1,2));
        } else {
            currentMonth_int = Integer.parseInt(month);
        }

        nextMonth_int = currentMonth_int + 1;

        if(nextMonth_int == 13) {
            return "01";
        }else if (nextMonth_int < 10){
            return "0"+ nextMonth_int;
        }else  {
            return nextMonth_int+"";
        }
    }

    String increaseYear(String year){
        return (Integer.parseInt(year) + 1) + "";
    }

    StringBuilder increaseMonthStr(StringBuilder monthStr){

        if (monthStr.length() != 7) {

        }

        if (monthStr.substring(5, 7).equals("12")) {
            monthStr = monthStr.replace(0, 4, this.increaseYear(monthStr.substring(0, 4)));
        }

        monthStr = monthStr.replace(5, 7, this.increaseMonth(monthStr.substring(5, 7)));

        return monthStr;
    }

    List<String> getMonthListFromPeriod(String periodDateStart, String periodDateEnd) {
        if (periodDateStart.compareTo(periodDateEnd) > 0) {

        }
        List<String> monthList = new ArrayList<>();
        monthList.add(periodDateStart);
        //如果是同一个月
        if (periodDateStart.equals(periodDateEnd)) {
            return monthList;
        }

        StringBuilder periodDateStartTmp = new StringBuilder(periodDateStart);
        StringBuilder periodDateEndTmp = new StringBuilder(periodDateEnd);
        while (!this.increaseMonthStr(periodDateStartTmp).toString().equals(periodDateEndTmp.toString())) {
            monthList.add(periodDateStartTmp.toString());
        }

        //加入最后一个月
        monthList.add(periodDateEnd);
        return monthList;
    }
}
