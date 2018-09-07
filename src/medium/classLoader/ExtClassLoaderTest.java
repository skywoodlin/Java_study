package medium.classLoader;

/**
 * Created by xjlin on 2018/8/30.
 * extension classloader －扩展类加载器，它负责加载JRE的扩展目录（JAVA_HOME/jre/lib/ext或者由java.ext.dirs系统属性指定的）
 * 中JAR的 类包。这为引入除Java核心类以外的新功能提供了一个标准机制。因为默认的扩展目录对所有从同一个JRE中
 * 启动的JVM都是通用的，所以放入这个目录的 JAR类包对所有的JVM和system classloader都是可见的。
 * 在这个实例上调用方法getParent()总是返回空值null，因为引导加载器bootstrap classloader不是一个真正的
 * ClassLoader实例。所以当大家执行以下代码时：返回
 * <p>
 * L:\IT_Software\jdks\jdk1.8.0_102\jre\lib\ext;C:\WINDOWS\Sun\Java\lib\ext
 * the parent of extension classloader : null
 * <p>
 * 因为extension classloader是system classloader的parent，而bootstrap classloader是extension classloader的parent，
 * 但它不是一个实际的classloader，所以为null。
 */

public class ExtClassLoaderTest{
    public static void main(String[] args){
        System.out.println(System.getProperty("java.ext.dirs"));
        ClassLoader extensionClassloader = ClassLoader.getSystemClassLoader().getParent();
        System.out.println("the parent of extension classloader : " + extensionClassloader.getParent());
    }
}
