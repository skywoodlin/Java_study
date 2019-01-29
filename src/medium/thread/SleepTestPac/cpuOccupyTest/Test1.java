package medium.thread.SleepTestPac.cpuOccupyTest;

import java.util.Date;

/**
 * Created by xjlin on 2019/1/17.
 */
public class Test1{
    public static void main(String[] args){
        String s = "";
        while(true) {
            //查看cpu占用率20%
            s = new Date().toString();// 模拟某个操作
            Thread.currentThread().yield();
        }
    }
}
