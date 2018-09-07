package medium.thread;

/*
死锁：

场景一：

同步嵌套。



*/

class SaleTicket5 implements Runnable
{
    private int tickets = 100;
    //定义一个boolean标记。
    boolean flag = true;
    Object obj = new Object();
    public void run()
    {
        if(flag)
            while(true)
            {
                synchronized(obj)//obj lock
                {
                    sale();
                }
            }
        else
            while(true)
                sale();
    }

    public synchronized void sale()//this lock
    {
        synchronized(obj)
        {
            if(tickets>0)
            {
                try{Thread.sleep(10);}catch(InterruptedException e){}//让线程到这里稍微停一下。
                System.out.println(Thread.currentThread().getName()+".....func...."+tickets--);
            }
        }
    }
}



class DeadLockDemo
{
    public static void main(String[] args) throws InterruptedException
    {
        SaleTicket5 t = new SaleTicket5();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        Thread.sleep(10);
        t.flag = false;
        t2.start();
    }
}