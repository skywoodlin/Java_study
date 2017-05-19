package forWork;

import java.io.IOException;

/**
 * Created by xjlin on 2017/1/18.
 */

// 废弃
public class RunCmd2 {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();

        String shutdownCmd = "cmd.exe /k d:/&& cd D:/zej-client/bin && startup.bat";
        try{
            rt.exec(shutdownCmd);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
