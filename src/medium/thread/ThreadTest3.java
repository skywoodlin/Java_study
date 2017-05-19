package medium.thread;

import static java.lang.Thread.sleep;

/**
 * Created by xjlin on 2017/1/4.
 */
public class ThreadTest3 {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                Runnable myRunnable = new MyRunnable1();
                Thread thread = new MyThread1(myRunnable);
                thread.start();
                try{
                    sleep(1000);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyRunnable1 implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        System.out.println("in MyRunnable run");
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

class MyThread1 extends Thread {

    private int i = 0;

    public MyThread1(Runnable runnable){
        super(runnable);
    }

    @Override
    public void run() {
        System.out.println("in MyThread run");
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}