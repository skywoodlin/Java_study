package NIO.FromWeb;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by xjlin on 2019/1/16.
 */
public class SocketChannelTest{
    public static void main(String[] args) throws IOException{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("www.sohu.com", 80));

        ByteBuffer buf = ByteBuffer.allocate(1024);
        while(!socketChannel.finishConnect()) {
            int bytesRead = socketChannel.read(buf);

        }



    }
}
