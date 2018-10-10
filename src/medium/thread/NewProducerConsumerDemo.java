package medium.thread;

/**
 * Created by xjlin on 2018/9/5.
 */
/*
解决多生产多消费的效率问题。
使用了JDK1.5 java.util.concurrent.locks包中的对象。
Lock接口：它的出现比synchronized有更多的操作。
			lock():获取锁。
			unlock():释放锁。

同步代码块或者同步函数的锁操作是隐式的。
JDK1.5 Lock接口，按照面向对象的思想，将锁单独封装成了一个对象。
				 并提供了对锁的显示操作。

Lock接口就是同步的替代。
1，将线程中的同步更换为Lock接口的形式。

替换完运行失败了。因为wait没有了同步区域，没有了所属的同步锁。
同步升级了。其中锁已经不是在任意对象，而是Lock类型的对象。
那么和任意对象绑定的监视器方法，是不是也升级了，有了专门和Lock类型锁的绑定的监视器方法呢？
查阅api。Condition接口替代了Object中的监视器方法。

以前监视器方法封装到每一个对象中。
现在将监视器方法封装到了Condition对象中。
方法名为：await  signal  signalAll

监视器对象Condition如何和Lock绑定呢？
可以通过Lock接口的newCondition()方法完成。

但是，问题依据，一样唤醒了本方。效率仍旧低！
*/

import java.util.concurrent.locks.*;

//描述资源。
class Res{
    private String name;
    private int count = 1;
    //创建新Lock。
    private Lock lock = new ReentrantLock();

    //创建和Lock绑定的监视器对象。创建两个。
    //生产者监视器。
    private Condition producer_con = lock.newCondition();
    //消费者监视器
    private Condition consumer_con = lock.newCondition();

    //定义标记。
    private boolean flag;

    //提供了给商品赋值的方法。
    public void set(String name)//
    {
        //获取锁。
        lock.lock();

        try{
            while(flag)//判断标记为true，执行wait。等待。为false。就生产。
                try{
                    producer_con.await();
                }catch(InterruptedException e){
                }//t0(等)  t1(等)
            this.name = name + "--" + count;//面包1  ，面包2 面包3

            count++;//2  3 4
            System.out.println(Thread.currentThread().getName() + "...生产者....." + this.name);//t0  面包1、 t0 面包2 t1 ，面包3
            //生成完毕，将标记改为true。
            flag = true;
            //生产完毕，应该唤醒一个消费者来消费。
            consumer_con.signal();
        }finally{
            //释放锁。
            lock.unlock();
        }
    }

    //提供一个获取商品的方法。
    public void get()//
    {
        lock.lock();
        try{
            while(!flag)
                try{
                    consumer_con.await();
                }catch(InterruptedException e){
                }//t2(等)  t3(等)
            System.out.println(Thread.currentThread().getName() + ".......消费者....." + this.name);//t2  面包1.

            //将标记改为false。
            flag = false;
            //消费完后，应该唤醒生产者一个。
            producer_con.signal();
        }finally{
            lock.unlock();
        }
    }
}


//生成者。
class Producer implements Runnable{
    private Res r;

    Producer(Res r){
        this.r = r;
    }

    public void run(){
        while(true)
            r.set("面包");
    }
}

//消费者
class Consumer implements Runnable{
    private Res r;

    Consumer(Res r){
        this.r = r;
    }

    public void run(){
        while(true)
            r.get();
    }
}


class NewProducerConsumerDemo{
    public static void main(String[] args){
        //1,创建资源。
        Res r = new Res();
        //2，创建两个任务。
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);

        //3,创建线程。
        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}