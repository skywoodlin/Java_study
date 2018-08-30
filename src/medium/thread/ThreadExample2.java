package medium.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xjlin on 2018/8/16.
 * https://juejin.im/post/5b723793f265da27f3759ac8?utm_source=gold_browser_extension
 * 启动线程的过程，是一个异步过程，启动线程立即返回，启动下一个进程。
 * 当多个线程对同一个变量add进行操作的时候，就会发生写写冲突。
 * 线程1、线程2 同时对值为0的变量进行操作，结果返回1，而不是2。如果这个地方想不明白，就请留言，或者看看文章顶部那些原理图。
 *
 * 作者：codeGoogle
 * 链接：https://juejin.im/post/5b723793f265da27f3759ac8
 * 来源：掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ThreadExample2{
    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
//                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count: {}" + count.get());
    }
    private static void add() {
        count.incrementAndGet();
        // count.getAndIncrement();
    }

}
