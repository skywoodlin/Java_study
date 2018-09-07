package medium.providerAndConsumer;

/**
 * Created by xjlin on 2018/9/4.
 * 多线程间的通信。多个线程都在处理同一个资源，但是处理的任务却不一样。
 * 生产者，消费者。
 *
 * 通过同步，解决了没生产就消费的问题。
 *
 * 但是出现了连续的生产没有消费的情况，和需求生产一个，消费一个的情况不符。
 *
 * 使用了等待唤醒机制。
 * wait():该方法可以让线程处于冻结状态，并将线程临时存储到线程池中。
 * notify():唤醒指定线程池中的任意一个线程。
 * notifyAll():唤醒指定线程池中的所以线程。
 *
 *
 *
 * 这些方法必须使用在同步中，因为它们用来操作同步锁上的线程的状态的。
 *
 * 在使用这些方法时，必须标识它们所属于的锁。标识方式就是 锁对象.wait();  锁对象.notify();  锁对象.notifyAll();
 *
 * 相同锁的notify()，可以获取相同锁的wait();
 *
 */


public class ProviderConsumerDemo2{
    public static void main(String[] args){
        Res2 r = new Res2();

        Provider2 pro = new Provider2(r);
        Consumer2 con = new Consumer2(r);

        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(con);

        t1.start();
        t2.start();
    }
}

//描述资源
class Res2{
    private String name;
    private int count = 1;

    private boolean flag;

    //提供了给生产商品的方法
    public synchronized void set(String name){
        if(flag) { //判断标记为true，执行wait。等待。为false。就生产。
            try{
                wait();
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + "--" + count;
        count++;
        System.out.println(Thread.currentThread().getName() + "。。。生产者。。。" + this.name);
        //生成完毕，将标记改为true。
        flag = true;

        //唤醒消费者。
        this.notify();
    }

    //提供一个获取商品的方法。
    public synchronized void get(){
        if(!flag) {
            try{
                wait();
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "。。。。。消费者。。。" + this.name);

        flag = false;
        notify();
    }


}

//生产者
class Provider2 implements Runnable{
    private Res2 r;

    Provider2(Res2 r){
        this.r = r;
    }

    @Override
    public void run(){
        while(true){
            r.set("面包");
        }
    }
}

//消费者
class Consumer2 implements Runnable{
    private Res2 r;

    Consumer2(Res2 r){
        this.r = r;
    }

    @Override
    public void run(){
        while(true){
            r.get();
        }
    }
}
