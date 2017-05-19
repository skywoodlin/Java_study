package medium.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by xjlin on 2017/1/3.
 */
public class TestThread{
    public static void main(String[] args) {


        SchedulerInitialize schedulerInitialize = new SchedulerInitialize();
        try{
            schedulerInitialize.load();
        }catch (Exception e) {
            e.printStackTrace();
        }

        final TestThread testThread = new TestThread();
        Timer myTimer = new Timer();
        try{
            myTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    testThread.scheduledFunction();
                }
            }, 1000l, 500l);
        }catch (Exception e) {
            e.printStackTrace();
        }

        /*try{
            testThread.addTaskPool(new Thread1("thread1"));
            testThread.addTaskPool(new Thread2("thread2"));
        }catch (Exception e) {
            e.printStackTrace();
        }*/
    }



    public void scheduledFunction() {
        anInt ++;
        String strInt = "" + anInt;
//        TestThread testThread = new TestThread();
        try{
            addTaskPool(new Thread1(strInt));
            addTaskPool(new Thread2(strInt+"2"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加到任务池
     * @param task
     */
    private void addTaskPool(Runnable task) throws Exception {
        if(!PlanTaskQueue.getInstance().addTask(task)) {
            throw new Exception("任务繁忙，下次执行");
        }
    }

    private int anInt = 0;
}
