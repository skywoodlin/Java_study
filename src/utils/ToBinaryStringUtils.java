package utils;

/**
 * Created by xjlin on 2018/10/11.
 */
public class ToBinaryStringUtils{



    /**
     * <pre>
     *     将int型数字转成其二进制形式
     * </pre>
     *
     * @param i
     * @return
     */
    public static String intToBinary(int i) {
        return Integer.toBinaryString(i);
    }

    public static String longToBinary(long l) {
        return Long.toBinaryString(l);
    }

    public static String doubleToBinary(double d) {
        long tempL = Double.doubleToLongBits(d); //[64, 70, 51, 51, 51, 51, 51, 51]
        return ToBinaryStringUtils.longToBinary(tempL);
    }

    public static String byteToBinary(byte b) {
        //注意byte只有8位
        String tmpStr = Integer.toBinaryString(b);
        int strLength = tmpStr.length();
        if(tmpStr.length() > 8) {
            int surplusBits = strLength % 8;  //按照8位分割时， 多余的头几个字符
            int byteNum = strLength / 8; //除去多余的头几个字符， 余下共几个8位字节

            return tmpStr.substring(surplusBits+8*(byteNum-1));
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 8-strLength; i++) {
                sb.append("0");
            }
            sb.append(tmpStr);
            return sb.toString();
        }
    }

    /**
     * byte[]数组转成二进制形式， 字节间不带空格
     * @param bArr
     * @return
     */
    public static String byteArrToBinary(byte[] bArr) {
        if(bArr.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for(byte b: bArr) {
            sb.append(ToBinaryStringUtils.byteToBinary(b));
        }
        return sb.toString();
    }

    //注意返回的时unicode下的二进制表示
    public static String charToBinary(char c) {
        return Integer.toBinaryString(c);
    }

    public static String intToBinaryForShow(int i) {
        return ToBinaryStringUtils.insertMarkToStringEvery8bits(Integer.toBinaryString(i), ' ');
    }

    public static String longToBinaryForShow(long l) {
        return ToBinaryStringUtils.insertMarkToStringEvery8bits(Long.toBinaryString(l), ' ');
    }

    public static String doubleToBinaryForShow(double d) {
        long tempL = Double.doubleToLongBits(d); //[64, 70, 51, 51, 51, 51, 51, 51]
        return ToBinaryStringUtils.insertMarkToStringEvery8bits(ToBinaryStringUtils.longToBinary(tempL), ' ');
    }

    //注意返回的是unicode下的二进制表示
    public static String charToBinaryForShow(char c) {
        return ToBinaryStringUtils.insertMarkToStringEvery8bits(Integer.toBinaryString(c), ' ');
    }

    public static String byteToBinaryForShow(byte b) {
        return ToBinaryStringUtils.insertMarkToStringEvery8bits(ToBinaryStringUtils.byteToBinary(b), ' ');
    }

    /**
     * byte[]数组转成二进制形式， 字节间带空格
     * @param bArr
     * @return
     */
    public static String byteArrToBinaryForShow(byte[] bArr) {
        if(bArr.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for(byte b: bArr) {
            sb.append(ToBinaryStringUtils.byteToBinary(b));
        }
        return ToBinaryStringUtils.insertMarkToStringEvery8bits(sb.toString(), ' ');
    }



    /**
     * <pre>
     *     将输入字符串从右至左每个8位插入一个标志位mark
     * </pre>
     *
     * @param str 输入的字符串
     * @param mark 插入的标志位
     * @return
     */
    private static String insertMarkToStringEvery8bits(String str, char mark) {
        int strLength = str.length();
        int surplusBits = strLength % 8;  //按照8位分割时， 多余的头几个字符
        int byteNum = strLength / 8; //除去多余的头几个字符， 余下共几个8位字节

        StringBuilder sb = new StringBuilder();
        if(surplusBits != 0) {
            sb.append(str.substring(0,surplusBits));
            sb.append(mark);
        }

        String surplusStr = str.substring(surplusBits);
        for(int i = 0; i < byteNum; i++) {
            int j = i * 8;
            sb.append(surplusStr.substring(j,j+8));
            if(i != byteNum -1) {
                sb.append(mark);
            }
        }

        return sb.toString();
    }

//    private static char[] char




}
