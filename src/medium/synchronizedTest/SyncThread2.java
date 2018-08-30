package medium.synchronizedTest;

/**
 * Created by xjlin on 2017/6/19.
 * 因为synchronized只锁定对象，每个对象只有一个锁（lock）与之相关联，而上面的代码等同于下面这段代码：
 *
 * SyncThread syncThread1 = new SyncThread();
 SyncThread syncThread2 = new SyncThread();
 Thread thread1 = new Thread(syncThread1, "SyncThread1");
 Thread thread2 = new Thread(syncThread2, "SyncThread2");
 thread1.start();
 thread2.start();
 这时创建了两个SyncThread的对象syncThread1和syncThread2，线程thread1执行的是syncThread1对象中的synchronized代码(run)，
 而线程thread2执行的是syncThread2对象中的synchronized代码(run)；我们知道synchronized锁定的是对象，这时会有两把锁
 分别锁定syncThread1对象和syncThread2对象，而这两把锁是互不干扰的，不形成互斥，所以两个线程可以同时执行。
 */
class SyncThread2 implements Runnable {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new SyncThread2(), "SyncThread1");
        Thread thread2 = new Thread(new SyncThread2(), "SyncThread2");
        thread1.start();
        thread2.start();
        try{
            Thread.sleep(288);
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(thread2.getState());
        System.out.println(thread1.getState());
    }

    private static int count;

    public SyncThread2() {
        count = 0;
    }

    public  void run() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCount() {
        return count;
    }
}