package NIO.mayiketang;
import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * Created by xjlin on 2019/1/14.
 *
 * 缓冲区是NIO 提高给传输文件和通道一起配合使用,存储数据.<br>
 * Buffer<br>
 * ByteBuffer<br>
 * LongBuffer<br>
 * InteigBuffer<br>
 * FloatBuffer<br>
 * DubboBuffer<br>
 */
public class BuffTest{

    /**
     * Buffer的核心方法：
     *  position<br> 缓冲区正在操作的位置 默认从0开始。
     * limit<br>  界面(缓冲区可用大小)
     * capacity;<br> 缓冲区最大容量，一旦声明不能改变
     *
     * 核心方法:
     * put() 往buff存放数据
     * get() 获取数据
     */
    @Test
    public void test001() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.put("abcde".getBytes());
        System.out.println("存放数据后---------------------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        System.out.println("读取buffer--------------------------------");
//        byteBuffer.get(bytes);会报错

        //要开启读取模式 才不会报错
        byteBuffer.flip();  //将position重置为0
        System.out.println("position: " + byteBuffer.position());
        System.out.println(byteBuffer.limit()); //5， 读取模式的时候limit类似于界限， 告诉只能读取5个
        System.out.println(byteBuffer.capacity());
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));


        //重复读取需要设置重复读取
        System.out.println("重复读取");
        byteBuffer.rewind();
        System.out.println("position: " + byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        byte[] bytes2 = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes2);
        System.out.println(new String(bytes2, 0, bytes2.length));


        //清空缓冲区
        System.out.println("清空缓冲区");
        byteBuffer.clear();
        System.out.println("position: " + byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //即使清空后还是能读取， 非法的
        //清空只是把limit等重置了， 你非去取还是可以取到的
        System.out.println((char)byteBuffer.get());


    }

    @Test
    public void test002() {
        System.out.println("test002");
    }
}
