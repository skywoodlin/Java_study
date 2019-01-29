package medium.thread.IsMainAProcessOrThread;

import utils.ThreadUtils;

/**
 * Created by xjlin on 2019/1/21.
 * 结论：
 *  1. main线程有可能提前结束， 其子线程可能继续运行
 *  2. （网络摘抄）：大意就是，当一个程序没有非守护线程的时候， 程序就结束了！！
 *     https://stackoverflow.com/questions/7416018/when-does-the-main-thread-stop-in-java
 *
 *     When a Java Virtual Machine starts up, there is usually a single non-daemon thread
 *     (which typically calls the method
 *     named main of some designated class). The Java Virtual Machine continues to execute
 *     threads until either of the following occurs:
            The exit method of class Runtime has been called and the security manager has permitted
            the exit operation to take place.
            All threads that are not daemon threads have died, either by returning from the call to
            the run method or by throwing an
            exception that propagates beyond the run method.
 *
 *
 * 结果：
 * Main thread started
 * 26852@skywoodlin
 * Pid is:26852
 * Main thread (almost) finished
 * Second thread started
 * main: [12] Thread-0
 * main: [6] Monitor Ctrl-Break
 * Thread-0: [12] Thread-0
 * main: [5] Attach Listener
 * Thread-0: [6] Monitor Ctrl-Break
 * Thread-0: [5] Attach Listener
 * Thread-0: [4] Signal Dispatcher
 * Thread-0: [3] Finalizer
 * Thread-0: [2] Reference Handler
 * Thread-0: [1] main
 * main: [4] Signal Dispatcher
 * main: [3] Finalizer
 * main: [2] Reference Handler
 * main: [1] main
 * afterSleep2Second-Thread-0: [13] DestroyJavaVM
 * afterSleep2Second-Thread-0: [12] Thread-0
 * afterSleep2Second-Thread-0: [6] Monitor Ctrl-Break
 * afterSleep2Second-Thread-0: [5] Attach Listener
 * afterSleep2Second-Thread-0: [4] Signal Dispatcher
 * afterSleep2Second-Thread-0: [3] Finalizer
 * afterSleep2Second-Thread-0: [2] Reference Handler
 * Second thread (almost) finished
 */
public class WhenDoesAProgramDie{
    public static void main(String[] args) {
        System.out.println("Main thread started");
        ThreadUtils.getProcessInfo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Second thread started");
                try {
                    ThreadUtils.getThreadsInfo(Thread.currentThread().getName());
                    Thread.sleep(2000);  // wait two seconds
                    ThreadUtils.getThreadsInfo("afterSleep2Second-" + Thread.currentThread().getName());
                } catch(Exception e){}
                System.out.println("Second thread (almost) finished");
            }
        }).start();
        System.out.println("Main thread (almost) finished");
        ThreadUtils.getThreadsInfo(Thread.currentThread().getName());
    }
}
