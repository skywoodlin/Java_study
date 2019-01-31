package DesignPattern.xjlinTest.singleton;

/**
 * Created by xjlin on 2019/1/31.
 * 来源：《如何正确地写出单例模式》
 * http://wuchong.me/blog/2014/08/28/how-to-correctly-write-singleton-pattern/
 *
 * 为知笔记： 如何正确地写出单例模式
 *
 * 此文展示了创建单例的各种方式， 以及它们是否线程安全， 还讨论了各种方式的优缺点。
 * 作者最终结论如下：
 * 就我个人而言，一般情况下直接使用饿汉式就好了，如果明确要求要懒加载（lazy initialization）会倾向于使用静态内部类，
 * 如果涉及到反序列化创建对象时会试着使用枚举的方式来实现单例。
 *
 */
public class HowToCreateThreadSafeSingleton{

}

/**
 * 懒汉式， 线程不安全
 * 这段代码简单明了，而且使用了懒加载模式，但是却存在致命的问题。
 * 当有多个线程并行调用 getInstance() 的时候，就会创建多个实例。也就是说在多线程下不能正常工作。
 */
class Singleton1 {
    private static Singleton1 instance;
    private Singleton1 (){}
    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}

/**
 * 懒汉式，线程安全
 * 为了解决上面的问题，最简单的方法是将整个 getInstance() 方法设为同步（synchronized）。
 *
 * 缺点：
 * 虽然做到了线程安全，并且解决了多实例的问题，但是它并不高效。
 * 因为在任何时候只能有一个线程调用 getInstance() 方法。
 * 但是同步操作只需要在第一次调用时才被需要，即第一次创建单例实例对象时。这就引出了双重检验锁。
 */
class Singleton2 {
    private static Singleton2 instance;
    private Singleton2 (){}
    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

/**
 * （有问题的）双重检验锁模式（double checked locking pattern），是一种使用同步块加锁的方法。
 * 程序员称其为双重检查锁，因为会有两次检查 instance == null，一次是在同步块外，一次是在同步块内。
 * 为什么在同步块内还要再检验一次？因为可能会有多个线程一起进入同步块外的 if，如果在同步块内不进行二次检验的话就会生成多个实例了。
 *
 * 这段代码看起来很完美，很可惜，它是有问题。主要在于instance = new Singleton()这句，这并非是一个原子操作，事实上在 JVM 中这句话大概做了下面 3 件事情。
 *
 * 1. 给 instance 分配内存
 * 2. 调用 Singleton 的构造函数来初始化成员变量
 * 3. 将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
 * 但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3，
 * 也可能是 1-3-2。如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，这时 instance已经是非 null 了（但却没有初始化），
 * 所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。
 */
class Singleton3 {
    private volatile static Singleton3 instance; //声明成 volatile
    private Singleton3 (){}
    public static Singleton3 getSingleton() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}

/**
 * （安全的）双重检验锁
 *  我们只需要将 instance 变量声明成 volatile 就可以了。
 *  其它注释看Singleton3
 *
 *
 *  （重要概念）volatile
 *  有些人认为使用 volatile 的原因是可见性，也就是可以保证线程在本地不会存有 instance 的副本，每次都是去主内存中读取。但其实是不对的。
 *  使用 volatile 的主要原因是其另一个特性：禁止指令重排序优化。也就是说，在volatile 变量的赋值操作后面会有一个内存屏障（生成的汇编代码上），
 *  读操作不会被重排序到内存屏障之前。比如上面的例子，取操作必须在执行完 1-2-3 之后或者 1-3-2 之后，不存在执行到 1-3然后取到值的情况。
 *  从「先行发生原则」的角度理解的话，就是对于一个 volatile 变量的写操作都先行发生于后面对这个变量的读操作（这里的“后面”是时间上的先后顺序）。
 */
class Singleton4 {
    private volatile static Singleton4 instance; //声明成 volatile
    private Singleton4 (){}
    public static Singleton4 getSingleton() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}

/**
 * 相信你不会喜欢“双重检验锁”这种复杂又隐含问题的方式，当然我们有更好的实现线程安全的单例模式的办法：
 * 饿汉式 static final field
 * 这种方法非常简单，因为单例的实例被声明成 static 和 final 变量了，
 * 在第一次加载类到内存中时就会初始化，所以创建实例本身是线程安全的。
 *
 * 缺点：
 * 缺点是它不是一种懒加载模式（lazy initialization），单例会在加载类后一开始就被初始化，即使客户端没有调用 getInstance()方法。
 * 饿汉式的创建方式在一些场景中将无法使用：譬如 Singleton 实例的创建是依赖参数或者配置文件的，在 getInstance()
 * 之前必须调用某个方法设置参数给它，那样这种单例写法就无法使用了
 */
class Singleton5{
    //类加载时就初始化
    private static final Singleton5 instance = new Singleton5();
    private Singleton5(){}
    public static Singleton5 getInstance(){
        return instance;
    }
}

/**
 * 我比较倾向于使用静态内部类的方法，这种方法也是《Effective Java》上所推荐的。
 *
 * 理由：
 * 这种写法仍然使用JVM本身机制保证了线程安全问题；由于 SingletonHolder 是私有的，除了 getInstance() 之外没有办法访问它，
 * 因此它是懒汉式的；同时读取实例的时候不会进行同步，没有性能缺陷；也不依赖 JDK 版本。
 */
class Singleton6 {
    private static class SingletonHolder {
        private static final Singleton6 INSTANCE = new Singleton6();
    }
    private Singleton6 (){}
    public static final Singleton6 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

/**
 * 我们可以通过EasySingleton.INSTANCE来访问实例，这比调用getInstance()方法简单多了。
 * 创建枚举默认就是线程安全的，所以不需要担心double checked locking，
 * 而且还能防止反序列化导致重新创建新的对象。但是还是很少看到有人这样写，可能是因为不太熟悉吧。
 */
enum EasySingleton{
    INSTANCE;
}






