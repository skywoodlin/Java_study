package medium.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;

/**
 * Created by xjlin on 2019/1/17.
 * https://www.cnblogs.com/z00377750/p/9183179.html
 * 一个最简单的Java程序有多少线程？
 * 通过下面程序可以计算出当前程序的线程总数。
 */
public class CountThreadNumForSimplestProgram{
    public static void main(String[] args) {
        // 计算方法1
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
        }
        int totalThread = threadGroup.activeCount();
        System.out.println("当前程序线程总数： " + totalThread);
        Thread[] lstThreads = new Thread[totalThread];
        threadGroup.enumerate(lstThreads);
        for (int i = 0; i < totalThread; i++) {
            System.out.println("线程号：" + lstThreads[i].getId() + " = " + lstThreads[i].getName());
        }
        // 计算方法2
        // 获取java线程管理器MXBean，dumpAllThreads参数：lockedMonitors参数表示是否获取同步的monitor信息，
        //lockedSynchronizers表示是否获取同步的synchronizer
        ThreadInfo[] threadInfos = ManagementFactory.getThreadMXBean().dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }

    }
}
