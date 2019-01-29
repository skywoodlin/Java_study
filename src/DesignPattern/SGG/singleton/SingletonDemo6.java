package DesignPattern.SGG.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 测试懒汉式单例模式(如何防止反射和反序列化漏洞)
 * @author 尚学堂高淇 www.sxt.cn
    //防止程序DesignPattern.SGG.singleton.Client2通过反射方式来破解单例模式
	//反序列化时，如果定义了readResolve()则直接返回此方法指定的对象。而不需要单独再创建新对象！
 *
 */
public class SingletonDemo6 implements Serializable {
	//类初始化时，不初始化这个对象（延时加载，真正用的时候再创建）。
	private static SingletonDemo6 instance;

	private SingletonDemo6(){ //私有化构造器
	    //重点在这里！！！！！！！！！！！！！！！！！！！！！！！！！
        //防止程序DesignPattern.SGG.singleton.Client2通过反射方式来破解单例模式
		if(instance!=null){
			throw new RuntimeException();
		}
	}

	//方法同步，调用效率低！
	public static synchronized SingletonDemo6  getInstance(){
		if(instance==null){
			instance = new SingletonDemo6();
		}
		return instance;
	}

	//反序列化时，如果定义了readResolve()则直接返回此方法指定的对象。而不需要单独再创建新对象！
    //通过反序列化会回调这个
	private Object readResolve() throws ObjectStreamException {
	    if(instance == null) {
	        instance = new SingletonDemo6();
        }
		return instance;
	}
	
}
