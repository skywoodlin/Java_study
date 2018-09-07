package medium.thread;

/**
 * Created by xjlin on 2018/9/6.
 */
public class JoinDemo{
    public static void main(String[] args) throws  InterruptedException{
        Demo1 demo1 = new Demo1();
        Thread t1 = new Thread(demo1);
        Thread t2 = new Thread(demo1);
        t1.setPriority(10);
        t2.setPriority(1);
        t2.start();
        t1.start();
//        t1.join(); //主线程会等待该线程终止， 但是t2线程不会， 互相抢夺执行权

        for(int x = 1; x < 40; x++) {
            System.out.println("in main......" + x);
        }
    }
}

class Demo1 implements Runnable{
    @Override
    public void run(){
        for(int x = 0; x<40; x++) {
            System.out.println(Thread.currentThread().getName() + "......" + x);
        }
    }
}
