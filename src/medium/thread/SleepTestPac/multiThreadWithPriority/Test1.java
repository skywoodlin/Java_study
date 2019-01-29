package medium.thread.SleepTestPac.multiThreadWithPriority;


/**
 * Created by xjlin on 2019/1/17.
 * 不使用任何方法
 *
 * 　　让线程们自己争用 CPU 时间
 *
 * 结果： 基本上平均
 */
public class Test1{
    public static void main(String[] args){
        for(int i = 0; i < 3; i++){
            Runnable myRunnable = new MyRunnable();
            Thread thread = new Thread(myRunnable);
            thread.start();
        }
    }
}



