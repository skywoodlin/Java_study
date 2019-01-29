package medium.thread.SleepTestPac.cpuOccupyTest;

import java.util.Date;

/**
 * Created by xjlin on 2019/1/17.
 */
public class Test3{
    public static void main(String[] args) throws InterruptedException{
        String s = "";
        while(true) {
            //查看cpu占用率：6%， 比sleep(0)和yield（）占用cup资源少多了
            s = new Date().toString();
            Thread.currentThread().sleep(1); //模拟某操作
        }
    }
}
