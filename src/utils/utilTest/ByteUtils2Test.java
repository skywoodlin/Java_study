package utils.utilTest;

import utils.ByteUtils;
import utils.ByteUtils2;

import java.util.Arrays;

/**
 * Created by xjlin on 2018/10/12.
 */
public class ByteUtils2Test{
    public static void main(String[] args) throws Exception{
        byte b = 0x35; // 0011 0101
        // 输出 [0, 0, 1, 1, 0, 1, 0, 1]
        System.out.println(Arrays.toString(ByteUtils2.getBooleanArray(b)));

        // 输出 00110101
        System.out.println(ByteUtils2.byteToBit(b)); //00110101

        // 输出 110101， JDK自带的方法，会忽略前面的 0
        System.out.println(Integer.toBinaryString(0x35));

        String str = "abcz";
        System.out.println(ByteUtils2.byte2hex(ByteUtils2.hex2byte(str)));

    }
}
