package medium.thread.IsMainAProcessOrThread;

import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * Created by xjlin on 2019/1/21.
 * https://note.youdao.com/ynoteshare1/index.html?id=85febc3ab33cc00102c024d04ef2ee09&type=note#/
 *
 *
 */
public class IsMainAProcessOrThread{
    public static void main(String[] args) throws IOException, InterruptedException {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(600000);
                    System.out.println(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(600000);
                    System.out.println(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
