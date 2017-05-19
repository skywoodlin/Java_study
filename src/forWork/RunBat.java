package forWork;

import java.io.IOException;

/**
 * Created by xjlin on 2017/1/18.
 */
public class RunBat {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        try {
            String path = "D:/wamp64/tomcat7_64/bin";
                String shutdownCmd = "D:/shutdownTomcat.bat " + "d: " + path;
                String startupCmd = "D:/startupTomcat.bat " + "d: " + path;
                rt.exec("cmd.exe /c start " + shutdownCmd);
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rt.exec("cmd.exe /c start " + startupCmd);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
