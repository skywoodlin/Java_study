package medium.thread;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by xjlin on 2017/1/3.
 */
public class PlanTaskQueue {
    private static PlanTaskQueue cache = new PlanTaskQueue();

    private int currCount = 0;//当前数量

    private int queueCapacity = 15000;//最大任务数

    private ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();

    private PlanTaskQueue() {
    }

    /**
     * 获取单例
     * @return
     */
    public static PlanTaskQueue getInstance() {
        return cache;
    }

    /**
     * 插入队列
     * @param data
     * @throws InterruptedException
     */
    public synchronized boolean addTask(Runnable data) throws InterruptedException {
        if (currCount > queueCapacity) {
            return false;
        }
        currCount++;
        queue.add(data);
        notifyAll();
        return true;
    }

    /**
     * 获取任务
     * @return
     * @throws InterruptedException
     */
    public synchronized Runnable getTask() throws InterruptedException{
        while (currCount <= 0) {
//            System.out.println(currCount);
            wait();
        }
        currCount--;
        return queue.poll();
    }
}
