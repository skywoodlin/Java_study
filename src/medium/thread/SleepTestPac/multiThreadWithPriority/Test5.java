package medium.thread.SleepTestPac.multiThreadWithPriority;

/**
 * Created by xjlin on 2019/1/17.
 * runnable1 优先值设为： MAX_PRIORITY
 * 结果： 很平均
 *
 */
public class Test5{
    public static void main(String[] args){
        Runnable myRunnable = new MyRunnable();
        Runnable myRunnable5 = new MyRunnable5();
        Thread thread = new Thread(myRunnable);
        Thread thread5 = new Thread(myRunnable5);
        thread.start();
        thread5.start();
    }
}



