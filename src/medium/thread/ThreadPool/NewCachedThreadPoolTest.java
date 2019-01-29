package medium.thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xjlin on 2019/1/17.
 *  * 此程序测试：
 *  * 1. 一个java程序中最多有多少个线程：
 *  运行结果：
 *  An unrecoverable stack overflow has occurred.
 * #
 * [thread 1188240 also had an error]# A fatal error has been detected by the Java Runtime Environment:
 *
 * #
 * #  EXCEPTION_STACK_OVERFLOW (0xc00000fd) at pc=0x0000000071383777, pid=476060, tid=0x00000000001221a0
 * #
 * # JRE version: Java(TM) SE Runtime Environment (8.0_102-b14) (build 1.8.0_102-b14)
 * # Java VM: Java HotSpot(TM) 64-Bit Server VM (25.102-b14 mixed mode windows-amd64 compressed oops)
 * # Problematic frame:
 * # V  [jvm.dll+0x213777]
 * Process finished with exit code -1
 */
public class NewCachedThreadPoolTest{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; ; i++)
            executorService.submit(new task());

    }

}

class task implements Runnable{
    @Override
    public void run(){
        try{
            Thread.sleep(500000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
