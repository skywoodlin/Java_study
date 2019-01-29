package medium.thread.ThreadPool;

/**
 * Created by xjlin on 2019/1/17.
 */
public class MyThread extends Thread{

    @Override

    public void run(){

        System.out.println(Thread.currentThread().getName() + "正在执行。。。");

    }

}
