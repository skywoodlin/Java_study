package medium.providerAndConsumer;

/**
 * Created by xjlin on 2018/9/4.
 */


public class ProviderConsumerDemo{
    public static void main(String[] args){
        Res r = new Res();

        Provider pro = new Provider(r);
        Consumer con = new Consumer(r);

        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(con);

        t1.start();
        t2.start();
    }
}

//描述资源
class Res{
    private String name;
    private int count;

    public synchronized void set(String name){
        this.name = name + "--" + count;
        count++;
        System.out.println(Thread.currentThread().getName() + "。。。生产者。。。" + this.name);
    }

    public synchronized void get(){
        System.out.println(Thread.currentThread().getName() + "。。。。。消费者。。。" + this.name);
    }


}

//生产者
class Provider implements Runnable{
    private Res r;

    Provider(Res r){
        this.r = r;
    }

    @Override
    public void run(){
        while(true){
            r.set("面包");
        }
    }
}

//消费者
class Consumer implements Runnable{
    private Res r;

    Consumer(Res r){
        this.r = r;
    }

    @Override
    public void run(){
        while(true){
            r.get();
        }
    }
}
