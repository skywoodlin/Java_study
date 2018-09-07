package medium.thread;
/*
验证同步函数使用的锁是this。

验证需求：
启动两个线程。
一个线程负责执行同步代码块(使用明锁)。
另一个线程使用同步函数(使用this锁)。
两个执行的任务是一样的都是卖票。如果他们没有使用相同的锁，说明他们没有同步。会出现数据错误。

怎么能让一个线程一直在同步代码块中，一个线程在同步函数呢？
可以通过切换的方式。
*/

class SaleTicket implements Runnable{
    private int tickets = 100;
    //定义一个boolean标记。
    boolean flag = true;
    Object obj = new Object();

    public void run(){
        if(flag)
            while(true){
                synchronized(this){
                    if(tickets > 0){
                        try{
                            Thread.sleep(10);
                        }catch(InterruptedException e){
                        }//让线程到这里稍微停一下。
                        System.out.println(Thread.currentThread().getName() + "....code....." + tickets--);
                    }
                }
            }
        else
            while(true)
                sale();
    }

    public synchronized void sale(){
        if(tickets > 0){
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
            }//让线程到这里稍微停一下。
            System.out.println(Thread.currentThread().getName() + ".....func...." + tickets--);
        }
    }
}


class ThisLockDemo{
    public static void main(String[] args) throws InterruptedException{
        SaleTicket t = new SaleTicket();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        Thread.sleep(10);
        t.flag = false;
        t2.start();
    }
}
