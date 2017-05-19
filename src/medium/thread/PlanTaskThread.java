package medium.thread;

/**
 * Created by xjlin on 2017/1/3.
 */
public class PlanTaskThread implements Runnable{

    private PlanTaskQueue queue = PlanTaskQueue.getInstance();
    @Override
    public void run() {
        while (true) {
            try {
                queue.getTask().run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
