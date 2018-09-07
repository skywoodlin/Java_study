package medium.providerAndConsumer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xjlin on 4018/9/4.
 */


public class ProviderConsumerDemo4{
    public static void main(String[] args){
        Res4 r = new Res4();

        Provider4 pro = new Provider4(r);
        Consumer4 con = new Consumer4(r);

        Thread t1 = new Thread(pro);
        Thread t4 = new Thread(con);

        t1.start();
        t4.start();
    }
}

class Bread {
    public static Bread produceBread() {
        return new Bread();
    }
    private static int currentNumber = 0;
    private int seqNumber;
    private Bread() {
        this.seqNumber = Bread.currentNumber++;
    }

    public int getSeqNumber(){
        return seqNumber;
    }

    public void setSeqNumber(int seqNumber){
        this.seqNumber = seqNumber;
    }
}

//描述资源
class Res4{
    private int numOfBreadInBarn = 0;
    private List<Bread> breadList = new ArrayList<>();

    private boolean flag;

    //提供了给生产面包的方法
    public synchronized void produceBread(){
        while(flag && numOfBreadInBarn == 100){ //判断标记为true，执行wait。等待。为false。就生产。
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        Bread newBread = Bread.produceBread();
        breadList.add(newBread);
        numOfBreadInBarn++;
        System.out.println(Thread.currentThread().getName() + "。。。生产了面包： 第" + newBread.getSeqNumber() + "号");

        //生成完毕，将标记改为true。
        if(numOfBreadInBarn == 100){
            //唤醒消费者。
            flag = true;
            this.notify();
        }
    }

    //提供一个获取商品的方法。
    public synchronized void consumeBread(){

        while(!flag && numOfBreadInBarn == 0){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        Iterator<Bread> it = breadList.iterator();
        while(it.hasNext()){
            Bread x = it.next();
            System.out.println(Thread.currentThread().getName() + "。。。。。消费了面包： 第" + x.getSeqNumber()+"号");
            it.remove();
            numOfBreadInBarn--;
            if(numOfBreadInBarn == 0){
                flag = false;
                this.notify();
            }
        }
    }


}

//生产者
class Provider4 implements Runnable{
    private Res4 r;

    Provider4(Res4 r){
        this.r = r;
    }

    @Override
    public void run(){
        while(true){
            r.produceBread();
        }
    }
}

//消费者
class Consumer4 implements Runnable{
    private Res4 r;

    Consumer4(Res4 r){
        this.r = r;
    }

    @Override
    public void run(){
        while(true){
            r.consumeBread();
        }
    }
}
