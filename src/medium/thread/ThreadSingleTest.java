package medium.thread;

/**
 * Created by xjlin on 2018/9/4.
 */
//饿汉式。相对与多线程并发，安全！

//class Single
//{
//    private static final Single SINGLE_INTSTANCE = new Single();
//    private Single(){}
//    public static Single getInstance()
//    {
//        return SINGLE_INTSTANCE;
//    }
//}

//懒汉式。延迟加载模式。
/*
在多线程并发访问时，会出现线程安全问题。
加了同步就可以解决问题。无论是同步函数，还是同步代码块都行。
但是，效率低了。
怎么解决效率低的问题。
可以通过if对单例对象的双重判断的形式。哦耶！


*/
class Single
{
    private static Single s = null;
    private Single(){}
    public static  Single getInstance()
    {
        if(s==null)
        {
            synchronized(Single.class)
            {
                if(s==null)
                    //-->0
                    s = new Single();
            }
        }
        return s;
    }
}

class Demo implements Runnable
{
    public void run()
    {
        Single.getInstance();
    }
}


class ThreadSingleTest
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
    }
}