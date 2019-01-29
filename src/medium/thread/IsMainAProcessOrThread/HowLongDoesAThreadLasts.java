package medium.thread.IsMainAProcessOrThread;

/**
 * Created by xjlin on 2019/1/21.
 *
 * 此程序测试线程多久会切换一次
 *
 * 结果：
 * 有时打印出10几条， 有时候打印出上百条。
 */
public class HowLongDoesAThreadLasts{
    private static int numOfThreads = 2;

    public static void main(String[] args){
        for (int i = 0; i < HowLongDoesAThreadLasts.numOfThreads; i++) {
            new Thread(new TestThread()).start();
        }
    }
}


class TestThread implements Runnable {
    private int i = 0;

    @Override
    public void run(){
        while(true) {
            //记录系统时间
            long t1 = System.currentTimeMillis();
            i++;
            System.out.println(Thread.currentThread().getName() + ": " + i);
            //记录系统时间
            long t2 = System.currentTimeMillis();
            System.out.println(t2-t1);
        }
    }
}
