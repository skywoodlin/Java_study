package NIO.mayiketang;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by xjlin on 2019/1/16.
 */
public class EncoderTest{
    public static void main(String[] args) throws CharacterCodingException{
        //获取编码器
        Charset charset = Charset.forName("UTF-8");
        CharsetEncoder encoder = charset.newEncoder();

        //获取解码器
        CharsetDecoder decoder = charset.newDecoder();

        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("坦坦荡荡打发手动阀撒旦");
        charBuffer.flip();

        //编码
        ByteBuffer byteBuffer = encoder.encode(charBuffer);
        for(int i= 0; i<21; i++) {
            System.out.println(byteBuffer.get());
        }

        //解码
        byteBuffer.flip();
        CharBuffer decode = decoder.decode(byteBuffer);
        System.out.println(decode.toString());



    }
}
