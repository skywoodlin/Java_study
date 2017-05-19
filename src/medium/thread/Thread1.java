package medium.thread;

/**
 * Created by xjlin on 2017/1/3.
 */
public class Thread1 implements Runnable{
    private String planId;
    public Thread1(String planId) {
        this.planId = planId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Thread1: " + planId);
    }

}
