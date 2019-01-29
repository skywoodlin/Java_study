package medium.thread;

/**
 * Created by xjlin on 2019/1/17.
 * 此程序测试：
 * 1. 一个java程序中最多有多少个线程： 结论， 都已经创建200000以上了， 还是没有崩溃， 只是内存占了16G以上，
 *    因此，进程最多可以创建的线程数是根据分配给调用栈的大小，以及操作系统（32位和64位不同）共同决定的。
 * 2. 这个程序还可以看当前程序中有多少个线程
 */
public class HowManyThreadCanWeCreateMax{
    public static void main(String[] args){
        ThreadGroup tg = new ThreadGroup("main");
        for(int i = 0; ; i++){
            System.out.println(i);
            new Thread(tg, new MyThreadForMaxTest(), "thread_"+i, 1024*1024*5120).start();
        }


    }
}

class MyThreadForMaxTest implements Runnable{
    @Override
    public void run(){
        while(true){
//            String s = "abc";
//            //消耗时间
//            if(!s.equals("bcd")){
//                System.out.println("我在耗费时间");
//            }

            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            while(threadGroup.getParent() != null){
                threadGroup = threadGroup.getParent();
            }
            int totalThread = threadGroup.activeCount();
            System.out.println("当前程序线程: "+ Thread.currentThread().getName() +", 总线程数： " + totalThread);
            try{
                Thread.currentThread().sleep(50000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}