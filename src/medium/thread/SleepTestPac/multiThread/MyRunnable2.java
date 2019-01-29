package medium.thread.SleepTestPac.multiThread;

import utils.WasteTime;

/**
 * Created by xjlin on 2019/1/17.
 */
public class MyRunnable2 implements Runnable{
    @Override
    public void run(){
        int i = 0;
        while(true){
            WasteTime.wasteTime(20);
            Thread.currentThread().yield();
            System.out.println(Thread.currentThread().getName() + ": " + i++);
        }
    }
}
