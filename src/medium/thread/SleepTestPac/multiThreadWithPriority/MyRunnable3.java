package medium.thread.SleepTestPac.multiThreadWithPriority;

import utils.WasteTime;

/**
 * Created by xjlin on 2019/1/17.
 * 事实证明， 设置线程优先级没有什么卵用
 */
public class MyRunnable3 implements Runnable{
    @Override
    public void run(){
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        int i = 0;
        while(true){
            WasteTime.wasteTime(20);
            try{
                Thread.currentThread().sleep(0);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + i++);
        }
    }
}
