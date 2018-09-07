package medium.classLoader;

/**
 * Created by xjlin on 2018/8/30.
 * system classloader －系统（也称为应用）类加载器，它负责在JVM被启动时，加载来自在命令java中的-classpath或者
 * java.class.path系统属性或 者 CLASSPATH操作系统属性所指定的JAR类包和类路径。总能通过静态方法
 * ClassLoader.getSystemClassLoader()找 到该类加载器。如果没有特别指定，则用户自定义的任何类加载器
 * 都将该类加载器作为它的父加载器。执行以下代码即可获得:
 *
 * 输出结果则为用户在系统属性里面设置的CLASSPATH。
 *
 * classloader 加载类用的是全盘负责委托机制。所谓全盘负责，即是当一个classloader加载一个Class的时候，这个Class所依赖的和引用的所有
 * Class也由这个classloader负责载入，除非是显式的使用另外一个classloader载入；委托机制则是先让parent（父）类加载器 (而不是super，
 * 它与parent classloader类不是继承关系)
 * 寻找，只有在parent找不到的时候才从自己的类路径中去寻找。此外类加载还采用了cache机制，也就是如果
 * cache中保存了这个Class就直接返回它，如果没有才从文件中读取和转换成Class，并存入cache，这就是为什么我们修改了Class但是必
 * 须重新启动JVM才能生效的原因。
 */
public class SystemClassLoaderTest{
    public static void main(String[] args){
        System.out.println(System.getProperty("java.class.path"));
    }
}
