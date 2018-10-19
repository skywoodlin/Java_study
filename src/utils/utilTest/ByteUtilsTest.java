package utils.utilTest;

import utils.ByteUtils;

import java.util.Arrays;

/**
 * Created by xjlin on 2018/10/11.
 */
public class ByteUtilsTest{
    public static void main(String[] args){
        byte[] bytes = "ab".getBytes();
        System.out.println(ByteUtils.byte2ToChar(bytes)); //慢

        byte[] bytes1 = ByteUtils.intToByte4(3333);
        for(byte by : bytes1){
            System.out.println(by); // 0,0,13,5
        }

        char c = 'z';
        byte[] charToByte2Arr = ByteUtils.charToByte2(c);
        for(byte by : charToByte2Arr){
            System.out.println(by); // 0,122
        }

        System.out.println(Arrays.toString(charToByte2Arr));  //"[0,122]"

        System.out.println(Arrays.toString(ByteUtils.intToByte4(-33)));

        System.out.println(Arrays.toString(ByteUtils.doubleToByte8(44.4)));
    }
}
