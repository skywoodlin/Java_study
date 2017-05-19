package medium.thread;

/**
 * Created by xjlin on 2017/1/3.
 */
public class Thread2 implements Runnable{
    private String planId;

    public Thread2(String planId) {
        this.planId = planId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Thread2: " + planId);
    }

}
