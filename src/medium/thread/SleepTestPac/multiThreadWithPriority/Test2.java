package medium.thread.SleepTestPac.multiThreadWithPriority;


/**
 * Created by xjlin on 2019/1/17.
 * runnable1 max priority
 * runnable2 min priority
 * 结果： 基本上平均
 */
public class Test2{
    public static void main(String[] args){
        Runnable myRunnable = new MyRunnable();
        Runnable myRunnable2 = new MyRunnable2();
        Thread thread = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable2);
        thread.start();
        thread2.start();
    }
}



