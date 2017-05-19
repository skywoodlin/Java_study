package medium.thread;

/**
 * Created by xjlin on 2017/1/3.
 */
public class SchedulerInitialize {
    private static final int threadNum = 2;

    public void load() throws Exception {
        for (int i = 0; i < threadNum; i++) {
            new Thread(new PlanTaskThread()).start();//启动线程
        }
    }
}
