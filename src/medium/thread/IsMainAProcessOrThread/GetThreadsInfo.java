package medium.thread.IsMainAProcessOrThread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by xjlin on 2019/1/21.
 * 此程序功能：
 * 1. 查看一个进程名和pid
 * 2. 查看进程中各线程id和名称
 *
 *
 * 输出：
 * 2700@skywoodlin
 * Pid is:2700
 * [13] Thread-1
 * [12] Thread-0
 * [6] Monitor Ctrl-Break
 * [5] Attach Listener
 * [4] Signal Dispatcher
 * [3] Finalizer
 * [2] Reference Handler
 * [1] main
 */

public class GetThreadsInfo{


    public static void main(String[] args){
        // 获取进程pid
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(60000);
                    System.out.println(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(60000);
                    System.out.println(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 获取java线程的管理MXBean
        ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的Monitor和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = tmxb.dumpAllThreads(false, false);
        // 遍历线程信息，打印出ID和名称
        for(ThreadInfo info : threadInfos){
            System.out.println("[" + info.getThreadId() + "] " + info.getThreadName());
        }
    }
}