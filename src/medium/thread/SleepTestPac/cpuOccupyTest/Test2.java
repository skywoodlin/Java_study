package medium.thread.SleepTestPac.cpuOccupyTest;

import java.util.Date;

/**
 * Created by xjlin on 2019/1/17.
 */
public class Test2{
    public static void main(String[] args) throws InterruptedException{
        String s = "";
        while(true) {
            //查看cpu占用率同样是22%
            s = new Date().toString();
            Thread.currentThread().sleep(0); //模拟某操作
        }
    }
}
