package medium.thread.SleepTestPac.multiThreadWithPriority;

import utils.WasteTime;

/**
 * Created by xjlin on 2019/1/17.
 * 事实证明， 设置线程优先级没有什么卵用
 */
public class MyRunnable5 implements Runnable{
    @Override
    public void run(){
        int i = 0;
        while(true){
            WasteTime.wasteTime(20);
            System.out.println(Thread.currentThread().getName() + ": " + i++);
        }
    }
}
