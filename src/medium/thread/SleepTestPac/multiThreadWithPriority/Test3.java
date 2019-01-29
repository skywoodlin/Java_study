package medium.thread.SleepTestPac.multiThreadWithPriority;

/**
 * Created by xjlin on 2019/1/17.
 * runnable2加了sleep（0）
 * 结果： 基本上平均
 */
public class Test3{
    public static void main(String[] args){
        Runnable myRunnable = new MyRunnable();
        Runnable myRunnable3 = new MyRunnable3();
        Thread thread = new Thread(myRunnable);
        Thread thread3 = new Thread(myRunnable3);
        thread.start();
        thread3.start();
    }
}



