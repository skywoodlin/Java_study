package utils;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by xjlin on 2019/1/21.
 */
public class ThreadUtils{
    public static void getProcessInfo() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid);
    }

    public static void getThreadsInfo(String threadName) {
        // 获取java线程的管理MXBean
        ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的Monitor和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = tmxb.dumpAllThreads(false, false);
        // 遍历线程信息，打印出ID和名称
        for(ThreadInfo info : threadInfos){
            System.out.println(threadName + ": [" + info.getThreadId() + "] " + info.getThreadName());
        }
    }
}
