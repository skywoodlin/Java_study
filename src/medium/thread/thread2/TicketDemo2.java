package medium.thread.thread2;

/**
 * Created by xjlin on 2018/9/3.
 * 创建线程的第二种方式， 实现runnable接口。
 * 1.
 */
public class TicketDemo2{
    public static void main(String[] args){
        SaleTicket2 t = new SaleTicket2();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class SaleTicket2 implements Runnable{
    private int tickets = 100;

    Object object = new Object();

    @Override
    public void run(){
        while(true){
            /**
             * 这个object可以是任意一个对象， 这边用new Object（）就可以了， 可以把它当作一把锁， 每次一个线程要进来的时候，
             * 先检查锁是否被占用（描述不一定准确， 就这个意思）， 占用的话， 线程就进不来， 阻塞了
             *
             * 好处： 解决了多线程的安全问题
             * 弊端： 降低效率
             */
            synchronized(object){
                if(tickets > 0){
                    int tmp = tickets;
                    /**
                     *  解决思想： 只要保证多条操作对共享变量访问的代码在某个时间段， 只能被一条线程所执行
                     *  同步的前提： 要用一个公用的锁， 即object是同一个， 不能每个线程都new 一个
                     *  关键字： synchronized(对象) {
                     *               需要被同步的代码
                     *           }
                     */
                    try{
//                        object.wait(20);  //让每个线程到这里稍微停一下  模拟产生线程同步问题
                        Thread.sleep(10);  //让线程到这里稍微停一下  模拟产生线程同步问题
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "......" + tickets-- + "...origin： " + tmp);

                }else{
                    Thread.currentThread().stop();
                }
            }

        }
    }
}
