package NIO.mayiketang;
import java.nio.ByteBuffer;

/**
 * Created by xjlin on 2019/1/14.
 */
public class MarkAndResetForBuffer{
    public static void main(String[] args){
//        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
//        String string = "abcd";
//
//        byteBuffer.put(string.getBytes());
//
//        //开启读取模式
//        byteBuffer.flip();
//        byte[] bytes = new byte[byteBuffer.limit()];
//        byteBuffer.get(bytes,0,2);
//        byteBuffer.mark(); //设置标记
//        System.out.println(new String(bytes,0,2)); //ab
//        System.out.println(byteBuffer.position());// 2
//
//        System.out.println("---------------------------------");
//        byteBuffer.get(bytes,2,2); //继续读取length个字节到bytes的offset处
//        System.out.println(new String(bytes, 0,4)); //abcd
//        System.out.println(byteBuffer.position()); //4
//
//        byteBuffer.reset();//返回mark标记
//        System.out.println(byteBuffer.position()); //2
        Double d = 3.30;
        System.out.println(d);
    }
}
