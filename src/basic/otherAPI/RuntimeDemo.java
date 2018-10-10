package basic.otherAPI;

/**
 * Created by xjlin on 2018/9/10.
 */
public class RuntimeDemo{
    public static void main(String[] args) throws Exception{
        Runtime runtime = Runtime.getRuntime();

        System.out.println(runtime.totalMemory()/1024/1024); //虚拟机内存总量
        System.out.println(runtime.maxMemory()/1024/1024); //虚拟机试图使用的最大内存两
        System.out.println(runtime.freeMemory()/1024/1024); //虚拟机空闲内存量
        System.out.println(runtime.availableProcessors()); //向 Java 虚拟机返回可用处理器的数目。

//        runtime.exec("notepad.exe"); //
        runtime.exec("winmine.exe"); //扫雷游戏 win10下没有了
    }
}
