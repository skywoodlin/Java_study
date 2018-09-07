package medium.thread;

/**
 * Created by xjlin on 2018/9/6.
 */
public class ThreadToString{
    public static void main(String[] args) throws InterruptedException{

        Demo2 demo2 = new Demo2();
        Thread t1 = new Thread(demo2);
        Thread t2 = new Thread(demo2);
        t2.start();
        t1.start();
        t1.join(); //主线程会等待该线程终止

        for(int x = 1; x < 40; x++){
            System.out.println(Thread.currentThread().toString() + x);
        }
    }
}


class Demo2 implements Runnable{
    @Override
    public void run(){
        for(int x = 0; x < 40; x++){
            System.out.println(Thread.currentThread().toString() + "......" + x);
        }
    }
}