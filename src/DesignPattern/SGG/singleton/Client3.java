package DesignPattern.SGG.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 测试多线程环境下五种创建单例模式的效率
 * @author 尚学堂高淇 www.sxt.cn
 *
 */
public class Client3 {
	
	public static void main(String[] args) throws Exception {
		
		long start = System.currentTimeMillis();
		int threadNum = 10;
		final CountDownLatch  countDownLatch = new CountDownLatch(threadNum);
		
		for(int i=0;i<threadNum;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					
					for(int i=0;i<1000000;i++){
//						Object o1 = SingletonDemo1.getInstance(); //46  饿汉式
//						Object o2 = SingletonDemo2.getInstance(); //484  懒汉式 方法同步
//						Object o3 = SingletonDemo3.getInstance(); // 50 双重检查锁， 一般不用
//						Object o4 = SingletonDemo4.getInstance(); // 47  静态内部类 很好
//						Object o5 = SingletonDemo5.INSTANCE; // 44 枚举
						Object o6 = SingletonDemo6.getInstance(); // 463 懒汉式单例模式防漏洞
					}
					
					countDownLatch.countDown();
				}
			}).start();
		}
		
		countDownLatch.await();	//main线程阻塞，直到计数器变为0，才会继续往下执行！
		
		long end = System.currentTimeMillis();
		System.out.println("总耗时："+(end-start));
	}
}
