package medium.thread.thread2;

/**
 * Created by xjlin on 2018/9/3.
 * 注意点：
 * 1. 任何时候取当前线程的名字： Thread.currentThread().getName();
 * 2. 调用run和调用start()什么区别： 调用start（）才会开启新的线程， 进而执行里头的run（）方法
 */
public class ThreadDemo{
    public static void main(String[] args){
        Demo d1 = new Demo("skywoodlin1");
        Demo d2 = new Demo("skywoodlin2");
        Demo d3 = new Demo("skywoodlin3");
        Demo d4 = new Demo("skywoodlin4");
        d1.start();
        d2.start();
        d3.start();
        d4.start();
        for(int i = 1; i <= 50; i++) {
            System.out.println(Thread.currentThread().getName() + ": main: ......" + i);
        }

    }
}


class Demo extends Thread{
    private String name;
    Demo(String name) {
        this.name = name;
    }
    @Override
    public void run(){
        for(int i = 1; i <= 50; i++) {
            //getName是Thread的方法， 打印线程的名称
            System.out.println(Thread.currentThread().getName() + ": " + name + "......" + i);
        }
    }

/*    public void show() {

    }*/
}