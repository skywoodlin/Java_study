package NIO.FromWeb;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

/**
 * Created by xjlin on 2019/1/16.
 * NIO文件写入以及读取
 *
 */
public class NIOExample{
    public static void main(String[] args) throws IOException{
        FileChannel channel = new RandomAccessFile("d:\\test\\2.txt", "rw").getChannel();
        channel.position(channel.size());  // 移动文件指针到末尾（追加写入）

        ByteBuffer byteBuffer = ByteBuffer.allocate(20);

        // 数据写入Buffer
        byteBuffer.put(("你好，世界！" + System.lineSeparator()).getBytes(StandardCharsets.UTF_8));

        // 开启读模式
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            channel.write(byteBuffer);
        }

        channel.position(0); // 移动文件指针到开头（从头读取）
        CharBuffer charBuffer = CharBuffer.allocate(10);
        CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();

        // 读出所有数据
        byteBuffer.clear();
        while (channel.read(byteBuffer) != -1 || byteBuffer.position() > 0) {
            byteBuffer.flip();

            // 使用UTF-8解码器解码
            charBuffer.clear();

            //decode()方法第三个参数 false 的作用就是让 Decoder 把无法映射的字节及其后面的数据都视作附加
            // 数据，因此 decode() 方法会在此处停止，并且 position 会回退到 0xe4 的位置
            decoder.decode(byteBuffer, charBuffer, false);
            String tmpstr = charBuffer.flip().toString();
            System.out.print(tmpstr);

            byteBuffer.compact(); // 数据可能有剩余
        }

        channel.close();
    }
}
