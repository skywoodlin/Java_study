package medium.thread;

/**
 * Created by xjlin on 2018/9/4.
 */
public class DeadLockTest{
    public static void main(String[] args){
        //创建线程任务
        Task t1 = new Task(true);
        Task t2 = new Task(false);
        new Thread(t1).start();
        new Thread(t2).start();
    }
}

class MyLock{
    public static final Object LOCK1 = new Object();
    public static final Object LOCK2 = new Object();
}

class Task implements Runnable{
    private boolean flag;

    Task(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run(){
        if(flag){
            synchronized(MyLock.LOCK1){
                System.out.println("if....LOCK1");
                synchronized(MyLock.LOCK2){
                    System.out.println("if....LOCK2");
                }
            }
        }else{
            synchronized(MyLock.LOCK2){
                System.out.println("else....LOCK2");
                synchronized(MyLock.LOCK1){
                    System.out.println("else....LOCK1");
                }
            }
        }
    }
}