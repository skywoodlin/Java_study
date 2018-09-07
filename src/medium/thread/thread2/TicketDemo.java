package medium.thread.thread2;

/**
 * Created by xjlin on 2018/9/3.
 *
 * 问题是： 每个线程都有一个自己的tickets变量， 线程对象持有资源
 *
 * 不能让线程对象持有资源应该怎么办？将线程和资源分离： 看TicketDemo2
 */
public class TicketDemo{
    public static void main(String[] args){
        SaleTicket t1 = new SaleTicket();
        SaleTicket t2 = new SaleTicket();
        SaleTicket t3 = new SaleTicket();
        SaleTicket t4 = new SaleTicket();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class SaleTicket extends Thread {
    private int tickets = 100;
    public void run() {
        while(true) {
            if(tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "......" + tickets--);
            }else{
                Thread.currentThread().stop();
            }

        }
    }
}
