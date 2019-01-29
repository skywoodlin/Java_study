package NIO.FromWeb;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by xjlin on 2019/1/16.
 * https://www.jianshu.com/p/f9f5df460883
 * 完整的示例
 */
public class NioExample2{
    public static void main(String[] args) throws IOException{
        Selector selector = Selector.open();
        // 初始化TCP连接监听通道
        ServerSocketChannel listenChannel = ServerSocketChannel.open();
        listenChannel.bind(new InetSocketAddress(9999));

        // 注册到selector（监听其ACCEPT事件）
        listenChannel.configureBlocking(false);
        SelectionKey key = listenChannel.register(selector, SelectionKey.OP_READ);


        while(true) {

            int readyChannels = selector.select();

            if(readyChannels == 0) continue;


            Set<SelectionKey> selectedKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while(keyIterator.hasNext()) {

                SelectionKey keyTmp = keyIterator.next();

                if(keyTmp.isAcceptable()) {
                    // 一个连接被ServerSocketChannel接受

                } else if (keyTmp.isConnectable()) {
                    // 与远程服务器建立了连接

                } else if (keyTmp.isReadable()) {
                    // 一个channel做好了读准备

                } else if (keyTmp.isWritable()) {
                    // 一个channel做好了写准备
                }

                keyIterator.remove();
            }
        }
    }


}
