package medium.thread.SleepTestPac.multiThread;


/**
 * Created by xjlin on 2019/1/17.
 * runnable4加了sleep（1）
 * 结果： 慢慢拉大， 不明显
 *
 */
public class Test4{
    public static void main(String[] args){
        Runnable myRunnable = new MyRunnable();
        Runnable myRunnable4 = new MyRunnable4();
        Thread thread = new Thread(myRunnable);
        Thread thread4 = new Thread(myRunnable4);
        thread.start();
        thread4.start();
    }
}



