package medium.thread;

/**
 * Created by xjlin on 2018/9/4.
 */

/*
如果同步函数被static修饰呢？

static方法随着类加载，这时不一定有该类的对象。但是一定有一个该类的字节码文件对象。
这个对象简单的表示方式就是 类名.class  Class
*/

class SaleTicket4 implements Runnable
{
    private static int tickets = 100;
    //定义一个boolean标记。
    boolean flag = true;
    public void run()
    {
        if(flag)
            while(true)
            {
                synchronized(SaleTicket4.class)
                {
                    if(tickets>0)
                    {
                        try{Thread.sleep(10);}catch(InterruptedException e){}//让线程到这里稍微停一下。
                        System.out.println(Thread.currentThread().getName()+"....code....."+tickets--);
                    }
                }
            }
        else
            while(true)
                sale();
    }

    public static  synchronized void sale()
    {
        if(tickets>0)
        {
            try{Thread.sleep(10);}catch(InterruptedException e){}//让线程到这里稍微停一下。
            System.out.println(Thread.currentThread().getName()+".....func...."+tickets--);
        }
    }
}



class StaticLockDemo
{
    public static void main(String[] args) throws InterruptedException
    {
        SaleTicket4 t = new SaleTicket4();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        Thread.sleep(10);
        t.flag = false;
        t2.start();
    }
}

