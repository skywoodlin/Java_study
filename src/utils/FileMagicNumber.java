package utils;

import java.io.FileInputStream;

/**
 * Created by xjlin on 2018/7/10.
 * 获取文件头几个字节
 */
public class FileMagicNumber{
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws Exception {
        FileInputStream is = new FileInputStream("D:\\1");
        byte[] b = new byte[7];
        is.read(b, 0, b.length);
        System.out.println(bytesToHexString(b));
    }
}
