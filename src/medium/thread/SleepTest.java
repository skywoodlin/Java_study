package medium.thread;

import static java.lang.Thread.sleep;

/**
 * Created by xjlin on 2018/9/6.
 * 这两个方法来自不同的类分别是Thread和Object
 * 最主要是sleep方法没有释放锁，而wait方法释放了锁，使得其他线程可以使用同步控制块或者方法(锁代码块和方法锁)。
 * wait，notify和notifyAll只能在同步控制方法或者同步控制块里面使用，而sleep可以在任何地方使用(使用范围)
 * sleep必须捕获异常，而wait，notify和notifyAll不需要捕获异常
 * sleep方法属于Thread类中方法，表示让一个线程进入睡眠状态，等待一定的时间之后，自动醒来进入到可运行状态，不会马上进入运行状态，因为线程调度机制恢复线程的运行也需要时间，一个线程对象调用了sleep
 * 方法之后，并不会释放他所持有的所有对象锁，所以也就不会影响其他进程对象的运行。但在sleep的过程中过程中有可能被其他对象调用它的interrupt(),
 * 产生InterruptedException异常，如果你的程序不捕获这个异常，线程就会异常终止，进入TERMINATED状态，如果你的程序捕获了这个异常，那么程序就会继续执行catch语句块(可能还有finally语句块)以及以后的代码。
 * 注意sleep()方法是一个静态方法，也就是说他只对当前对象有效，通过t.sleep()让t对象进入sleep，这样的做法是错误的，它只会是使当前线程被sleep 而不是t线程
 *  wait属于Object的成员方法，一旦一个对象调用了wait方法，必须要采用notify()和notifyAll()方法唤醒该进程;如果线程拥有某个或某些对象的同步锁，那么在调用了wait()
 *  后，这个线程就会释放它持有的所有同步资源，而不限于这个被调用了wait()方法的对象。wait()方法也同样会在wait的过程中有可能被其他对象调用interrupt()方法而产生
 */
public class SleepTest{
    public static void main(String[] args){
        Thread t1 = new Thread(new SleepRunner());
        Thread t2 = new Thread(new SleepRunner());

        t1.start();
        t2.start();

    }
}


class MyLock2{
    public static final Object LOCK = new Object();
}

class SleepRunner implements Runnable{
    @Override
    public void run(){
        synchronized(MyLock2.LOCK){
            while(true){
                try{
                    sleep(1000);
                }catch(Exception e){

                }
                System.out.println(Thread.currentThread().getName() + " running");
            }
        }
    }
}