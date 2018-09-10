package coreJavaVolumn.Volumn1.CP6.proxy.UserServiceProxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xjlin on 2018/8/31.
 * 产看
 */
public class GetClassInnerByte{
    public static void main(String[] args) throws IOException{
        GetClassInnerByte.createProxyFile();
    }

    public static void createProxyFile() throws IOException{
        byte[] generateProxyClass = ProxyGenerator.generateProxyClass("$Proxy0", new Class<?>[]{UserService.class});
        FileOutputStream outputStream = new FileOutputStream("$Proxy0.class");
        outputStream.write(generateProxyClass);
        outputStream.close();
    }
}
